import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> pivo = new ArrayList<Integer>();
        pivo.add(0);
        pivo.add(1);
       for(int i = 0; i < n; i++) {
            pivo.add((pivo.get(i) + pivo.get(i+1)) % 1234567);
        }
        answer = pivo.get(n);
        return answer;
    }
}