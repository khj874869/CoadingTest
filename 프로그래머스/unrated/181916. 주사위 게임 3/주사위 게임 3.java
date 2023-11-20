import java.util.*;
import java.util.stream.*;

class Solution {
    public static int solution(int a, int b, int c, int d) {
        if (a == b && b == c && c == d) { 
            return 1111 * a; 
        } else if (a == b && b == c) { 
            return ((10 * a + d) * (10 * a + d)); 
        } else if (a == c && c == d) { 
            return ((10 * a + b) * (10 * a + b));
        } else if (a == b && b == d) { 
            return ((10 * a + c) * (10 * a + c));
        } else if (b == c && c == d) { 
            return ((10 * b + a) * (10 * b + a));
        } else if (a == b && c == d) { 
            return ((a + c) * (Math.abs(a - c)));
        } else if (a == c && b == d) { 
            return ((a + b) * (Math.abs(a - b)));
        } else if (a == d && b == c) {
            return ((a + b) * (Math.abs(a - b)));
        } else if (a == b && c != d) { 
            return (c * d);
        } else if (a == c && b != d) { 
            return (b * d);
        } else if (a == d && b != c) { // ad가 같고 bc가 다르다면
            return (b * c);
        } else if (b == c && a != d) { 
            return (a * d);
        } else if (b == d && a != c) {
            return (a * c);
        } else if (c == d && a != b) { 
            return (a * b);
        } else {
            return Math.min(Math.min(a, b), Math.min(c, d));
        }
    }
}