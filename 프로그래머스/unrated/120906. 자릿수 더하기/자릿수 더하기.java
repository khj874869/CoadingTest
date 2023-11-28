import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String an = String.valueOf(n);
        String [] pan = an.split("");
        for(int i =0 ; i < pan.length ;i++){
            answer += Integer.parseInt(pan[i]);
        }
        return answer;
    }
}