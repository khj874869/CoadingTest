import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        
        Map<String,Integer> resource = new HashMap<String,Integer>();
        resource.put("code",0);
        resource.put("date",1);
        resource.put("maximum",2);
        resource.put("remain",3);
        
        int[][] answer = Arrays.stream(data).filter(x -> x[resource.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(answer,(o1,o2) -> o1[resource.get(sort_by)] - o2[resource.get(sort_by)]);
        
        return answer;
    }
}