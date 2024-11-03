import java.util.*;
class Solution {
    private static List<int[]> arr = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        
        move(n,1,2,3);
        answer= arr.stream().toArray(int[][]::new);     
        return answer;
    }
    private static void move(int hanoi,int start,int mid,int end){
        if(hanoi==0){
            return;
        }
        move(hanoi - 1, start, end, mid);
        arr.add(new int[]{start, end});
        move(hanoi - 1, mid, start, end);
        
    }
}