class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int edge = 0;
        int x = 0;
        int y = 0;
        for(int i = total / 3; i >= 0 ; i--){
            if(total % i == 0){
                x = i;
                y = total / i;
                edge = (x + y) * 2 - 4;
                if(brown == edge)
                    return new int[]{x,y};
            }   
        }
        return null;
    }
}