class Solution {
    public String solution(String s) {
        String answer = "";
        int sa =0;
        if(s.length()%2==1){
           sa = s.length()/2;            
           answer = String.valueOf(s.charAt(sa));
        }else{
            sa = s.length()/2;            
           answer =   String.valueOf(s.charAt(sa-1))+String.valueOf(s.charAt(sa)) ;
        }
        return answer;
    }
}