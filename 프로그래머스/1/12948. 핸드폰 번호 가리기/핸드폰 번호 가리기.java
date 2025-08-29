class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int lastOfFour = phone_number.length()-4;     
        for(int i = 0; i<lastOfFour ; i++ ){
            answer += "*";
        }
        
        answer += phone_number.substring(lastOfFour,phone_number.length());
        return answer;
    }
}