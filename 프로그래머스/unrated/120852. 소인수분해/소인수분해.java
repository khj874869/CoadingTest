import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 2 ; i<=n;i++){
            if(n%i==0){
                while(n%i==0){
                    n/=i;
                }
                list.add(i);
            }
        }
        int [] answer = new int[list.size()];
        for(int j =0 ; j <answer.length ; j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}