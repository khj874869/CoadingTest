import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int total_len = 0 ; 
        int ipos =0, start=0,end ; 
         total_len = Integer.parseInt(video_len.split(":")[0])*60+Integer.parseInt(video_len.split(":")[1]);
           ipos = Integer.parseInt(pos.split(":")[0])*60+Integer.parseInt(pos.split(":")[1]);
         start = Integer.parseInt(op_start.split(":")[0])*60+Integer.parseInt(op_start.split(":")[1]);
         end = Integer.parseInt(op_end.split(":")[0])*60 + Integer.parseInt(op_end.split(":")[1]);
        
        if(ipos>=start && ipos<=end){
            ipos = end;
        }
        for(int i = 0 ; i<commands.length;i++){
            if("next".equals(commands[i])){
                ipos += 10;
                if(total_len-ipos<10){
                    ipos = total_len;
                }
            }else{
                ipos-= 10; 
                if(ipos  <0){
                    ipos = 0;
                }
            }
             if(ipos>=start && ipos<=end){
            ipos = end;
        }
            
            
        }      
        answer = String.format("%02d:%02d",ipos/60,ipos%60);
        
        return answer;  
              
              

    }
}