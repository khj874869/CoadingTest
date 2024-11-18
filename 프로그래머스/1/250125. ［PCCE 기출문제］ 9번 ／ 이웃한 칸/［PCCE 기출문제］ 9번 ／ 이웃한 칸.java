class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int count = 0;
        int len = board.length;
        int [] dh = {1,0,-1,0};
        int [] dw = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int checkh = h + dh[i];
            int checkw = w + dw[i];
          if(checkh>=0 && checkh<len && checkw>=0 && checkw<len)  {
              if(board[h][w].equals(board[checkh][checkw])){
                  count++;
                  answer =count;
              }
          }
        }
        return answer;
    }
}