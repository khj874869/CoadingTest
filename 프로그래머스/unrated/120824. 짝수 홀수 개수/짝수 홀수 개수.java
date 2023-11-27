class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even = 0; 
        int doc =0;
        for(int i =0 ; i<num_list.length ; i++){
            if(num_list[i]%2!=0){
                doc++;
                answer[answer.length-1] =doc;  
            }else{
                even++;
                answer[0] = even;
            }
        }
        return answer;
    }
}