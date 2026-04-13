class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int i = Math.max(a,b);
        int j = Math.min(a,b);
        for(;j<=i;j++){
            answer+=j;
        }
         if(a==b){
            answer = a;
        }
        return answer;
    }
}