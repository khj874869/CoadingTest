class Solution {
    public String solution(String my_string) {
        String answer = "";
        String []s = {"a","e","i","o","u"};
        for(int i =0; i<s.length;i++){
            if(my_string.contains(s[i])){
            answer = my_string.replaceAll(s[i],"");
            my_string = answer;
            }
            else{
                answer = my_string;
            }
        }
        
        return answer;
    }
}