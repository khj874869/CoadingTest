class Solution {
    public int solution(String s) {
        int answer = 0;
        String [] commandString ={"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<commandString.length;i++){
            s = s.replace(commandString[i],String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}