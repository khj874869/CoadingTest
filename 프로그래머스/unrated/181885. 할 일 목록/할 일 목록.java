import java.util.*;
class Solution {
    public List<String> solution(String[] todo_list, boolean[] finished) {      
        List<String>answer = new ArrayList<String>();
        for(int i = 0 ; i<todo_list.length;i++){
            if(finished[i] == false){
                answer.add(todo_list[i]);
            }
        }
        return answer;
    }
}