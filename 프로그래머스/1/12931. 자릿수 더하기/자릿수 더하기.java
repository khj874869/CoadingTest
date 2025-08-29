import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        char [] str = String.valueOf(n).toCharArray();
        for(int i = 0; i<str.length;i++){
            answer += str[i]-'0';
        }
        System.out.println("Hello Java");

        return answer;
    }
}