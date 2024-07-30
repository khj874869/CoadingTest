import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
     int answer = 0;
    Stack<Integer> hamber = new Stack<Integer>();
        for(Integer h : ingredient){
            hamber.push(h);
        if(hamber.size()>=4){
            if(hamber.get(hamber.size()-4)==1 &&
               hamber.get(hamber.size()-3)==2&&
               hamber.get(hamber.size()-2)==3&&
               hamber.get(hamber.size()-1)==1
              ){
                answer++; 
                hamber.pop();hamber.pop();hamber.pop();hamber.pop();
            }
        }
        }
        return answer;
    }
}