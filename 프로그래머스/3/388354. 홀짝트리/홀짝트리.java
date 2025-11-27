import java.util.*;

class Solution {
    static class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) return;
            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
        }
    }

    public int[] solution(int[] nodes, int[][] edges) {
        int n = nodes.length;
        // 노드 번호 → 인덱스 매핑
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(nodes[i], i);
        }

        DSU dsu = new DSU(n);

        int[] numParity = new int[n];  // 노드 값 홀짝
        int[] degParity = new int[n];  // 차수 홀짝 (간선 처리하면서)
        for (int i = 0; i < n; i++) {
            numParity[i] = nodes[i] & 1;  // 홀수면 1, 짝수면 0
        }

        // 간선 입력 처리: 차수 parity 계산 + 컴포넌트 병합
        for (int[] e : edges) {
            int a = idx.get(e[0]);
            int b = idx.get(e[1]);
            degParity[a] ^= 1;
            degParity[b] ^= 1;
            dsu.union(a, b);
        }

        int[] comp0 = new int[n];  // 각 컴포넌트별 a=0 개수
        int[] comp1 = new int[n];  // 각 컴포넌트별 a=1 개수

        // 각 노드의 a값 계산 후 컴포넌트별로 집계
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            int a = numParity[i] ^ degParity[i];
            if (a == 0) comp0[root]++;
            else comp1[root]++;
        }

        int evenOddTreeCount = 0;      // 홀짝 트리 개수
        int reverseEvenOddTreeCount = 0; // 역홀짝 트리 개수

        // 대표 루트들만 확인
        for (int i = 0; i < n; i++) {
            if (dsu.parent[i] == i) {  // i가 그 컴포넌트의 루트일 때
                if (comp0[i] == 1) evenOddTreeCount++;
                if (comp1[i] == 1) reverseEvenOddTreeCount++;
            }
        }

        return new int[] { evenOddTreeCount, reverseEvenOddTreeCount };
    }
}
