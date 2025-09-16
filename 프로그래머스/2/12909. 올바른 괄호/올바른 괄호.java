class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int sum = 0 ;
        for(int i = 0 ;i<s.length();i++){
            sum += (s.charAt(i) == '(') ? 1:-1;         
            if (sum <0) return false;
        }    
        return sum ==0;
    }
}