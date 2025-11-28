class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char c : s.toCharArray()){
	if(c == ' ') answer += ' ';
	
	if(Character.isLowerCase(c)){
	char shifted = (char)(((c-'a'+n)%26) + 'a');
	answer += shifted;
	} else if(Character.isUpperCase(c)){
	char shifted=(char)(((c-'A'+n)%26) +'A');
	answer += shifted;
	}
}

        
        return answer;
    }
}