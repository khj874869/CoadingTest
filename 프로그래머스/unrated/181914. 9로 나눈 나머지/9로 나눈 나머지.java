import java.util.*;
class Solution {
    public int solution(String number) {
        int answer = 0;
        int count =0 ; 
        String[] number_list = number.split("");
        for(int i = 0; i<number.length();i++){
            count += Integer.parseInt(number_list[i]);
        }
        answer = count%9;
        return answer;
    }
}