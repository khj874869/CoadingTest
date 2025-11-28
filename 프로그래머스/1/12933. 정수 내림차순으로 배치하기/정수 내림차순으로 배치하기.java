import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        char [] qa = String.valueOf(n).toCharArray();
        Arrays.sort(qa);
        StringBuilder sb = new StringBuilder(new String(qa));
        sb.reverse();
        
        return Long.parseLong(sb.toString());
    }
}