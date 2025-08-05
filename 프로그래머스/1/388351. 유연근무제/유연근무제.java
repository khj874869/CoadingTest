class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;
        answer = n;
        startday--;
        for(int i= 0 ; i<n ; i++){
            int limit = schedules[i]%100+10 >= 60 ? schedules[i]+ 50 : schedules[i] + 10;
            for(int j = 0; j<7; j++){
                if((startday+j)%7 ==5 || (startday+j)%7 == 6){
                    continue;
                }
                if(timelogs[i][j] >limit){
                    answer--;
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}