class Solution {
    public int[] solution(int brown, int yellow) {
      int total = brown + yellow;
       for (int h = 3; h <= Math.sqrt(total); h++) {
        if (total % h != 0) continue;
        int w = total / h; 
        int edge = 2 * (w + h) - 4;
        if (edge == brown) return new int[]{w, h};    
     }
    return null; 
    }
}