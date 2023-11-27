class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        for(int i =0 ; i<answer.length;i++){
            answer[0]= money/5500;
            answer[answer.length-1]=money%5500;
        }
        
        return answer;
    }
}