import java.util.*;

class Solution {
    // 포인트 하나의 좌표를 표현하기 위한 간단한 클래스
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int n = points.length;        // 포인트 개수
        int x = routes.length;        // 로봇 개수

        // 1. 포인트 번호 -> 좌표 매핑 (1-based라서 크기 n+1로)
        Point[] pointMap = new Point[n + 1];
        for (int i = 0; i < n; i++) {
            int r = points[i][0];
            int c = points[i][1];
            pointMap[i + 1] = new Point(r, c); // 포인트 번호는 i+1
        }

        // 2. 각 로봇의 "시간별 위치 리스트"를 미리 계산
        // paths[i] = i번 로봇의 t=0,1,2,... 에서의 위치
        List<Point>[] paths = new ArrayList[x];
        int maxTime = 0; // 가장 오래 움직인 로봇의 마지막 시간

        for (int i = 0; i < x; i++) {
            paths[i] = new ArrayList<>();

            int[] route = routes[i];

            // 출발 지점 (routes[i][0] 포인트)
            Point start = pointMap[route[0]];
            int currR = start.r;
            int currC = start.c;

            // 시간 0 위치 추가
            paths[i].add(new Point(currR, currC));

            // route 상의 연속된 포인트들 사이 이동을 모두 시뮬레이션
            for (int j = 1; j < route.length; j++) {
                Point target = pointMap[route[j]];
                int targetR = target.r;
                int targetC = target.c;

                // r 좌표 먼저 맞추기
                while (currR != targetR) {
                    if (currR < targetR) currR++;
                    else currR--;
                    paths[i].add(new Point(currR, currC));
                }

                // 그 다음 c 좌표 맞추기
                while (currC != targetC) {
                    if (currC < targetC) currC++;
                    else currC--;
                    paths[i].add(new Point(currR, currC));
                }
            }

            // 이 로봇의 마지막 시간 = paths[i].size() - 1
            maxTime = Math.max(maxTime, paths[i].size() - 1);
        }

        // 3. 0초부터 maxTime초까지, 각 시각마다 충돌(위험 상황) 카운트
        int answer = 0;

        for (int t = 0; t <= maxTime; t++) {
            // 좌표 -> 해당 시각에 그 좌표에 있는 로봇 수
            Map<Long, Integer> countMap = new HashMap<>();

            for (int i = 0; i < x; i++) {
                List<Point> path = paths[i];
                if (t < path.size()) {
                    Point p = path.get(t);
                    long key = encode(p.r, p.c);
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                }
                // t >= path.size() 인 경우 이 로봇은 이미 물류 센터를 떠난 상태이므로 무시
            }

            // 이 시각에 충돌이 발생한 좌표 수만큼 answer 증가
            for (int cnt : countMap.values()) {
                if (cnt >= 2) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // (r, c)를 long으로 인코딩 (r, c 최대 100이라 1000 곱해도 충돌 없음)
    private long encode(int r, int c) {
        return r * 1000L + c;
    }
}
