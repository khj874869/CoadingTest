class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
          while(count>0){
              answer += price*count;
              count--;
          }
         answer =   answer-money;
         if(answer>0){
             answer = answer;
         }else{
             answer = 0;
         }
        return answer;
    }
}