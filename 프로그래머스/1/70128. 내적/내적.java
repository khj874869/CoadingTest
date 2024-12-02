class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 1234567890;
        int concat =0; 
        for(int i = 0 ; i < a.length;i++){
            concat+=a[i]*b[i];
        }
        
        answer = concat;
        return answer;
    }
}