class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int count =0;
        answer = 12000*n + k*2000;
        if(n/10!=0){
            count=n/10;
            answer = 12000*n + (k*2000-count*2000);
        }
        return answer;
    }
}