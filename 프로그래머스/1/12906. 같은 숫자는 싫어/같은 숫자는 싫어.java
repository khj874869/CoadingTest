import java.util.Stack;
public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer>ham = new Stack<Integer>();
        
       for(int i : arr){
           if(ham.empty()|| !ham.peek().equals(i)){
               ham.push(i);
           }
       }
        
        
        
        

        return ham.stream().mapToInt(i -> i).toArray();
    }
}