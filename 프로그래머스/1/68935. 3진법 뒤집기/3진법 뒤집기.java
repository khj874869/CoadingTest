import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";

        while (n != 0) {
            s += String.valueOf(n % 3);
            n /= 3;
        }
        
        for (int j = 0 ;j < s.length(); j++) {
            answer += Character.getNumericValue(s.charAt(s.length()-1-j)) * (int)Math.pow(3,j);
        }

        return answer;
    }
}