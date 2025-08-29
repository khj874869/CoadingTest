import java.util.*;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String conv = String.valueOf(x);
        int result = 0; 
        for(int i = 0 ; i <conv.length();i++){
            char ch = conv.charAt(i);
        if (Character.isDigit(ch)) {   
              result += ch - '0';      
            }          
        }
        if(x%result == 0 ){
            answer = true;
        }else{
            answer = false;
        }
        
        return answer;
    }
}