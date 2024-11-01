class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int x = 1 ; x<=r2;x++)
        {
            long min = (long)Math.ceil(Math.sqrt(1.0*r1*r1-1.0*x*x));
            long max = (long)Math.floor(Math.sqrt(1.0*r2*r2-1.0*x*x));
            answer+= (max-min+1)*4;
        }
        
        
        return answer;
    }
}