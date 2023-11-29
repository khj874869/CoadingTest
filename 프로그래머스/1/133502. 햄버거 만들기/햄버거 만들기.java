import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> ham = new Stack<Integer>();
        for(Integer h : ingredient){
        ham.push(h);
        if(ham.size()>=4){
            if(ham.get(ham.size()-4) == 1&&
               ham.get(ham.size()-3) == 2&&  
               ham.get(ham.size()-2) == 3&&
               ham.get(ham.size()-1) == 1)
            {answer++;
             ham.pop();ham.pop();ham.pop();ham.pop();
            }
        }
        }
        
        return answer;
    }
}