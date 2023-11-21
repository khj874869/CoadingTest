import java.util.*;
class Solution {
    public List<Integer> solution(int[] num_list) {
        Arrays.sort(num_list);
        List <Integer> list = new ArrayList<Integer>();
        for(int i =5 ; i < num_list.length;i++){
            list.add(num_list[i]);
        }
        return list;
    }
}