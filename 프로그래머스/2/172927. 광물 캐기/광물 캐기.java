import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int cnt = Math.min(minerals.length/5+1,picks[0]+picks[1]+picks[2]);
        int [][] select = new int [cnt][3];
        int dia = 0;
        int iron = 0;
        int stone = 0;
        for(int i =0 ; i<minerals.length;i+=5){
            if(i/5==cnt){
                break;
            }
            for(int j =i; j<i+5;j++){
               String s = minerals[j];
                if(s.equals("diamond")){
                 dia += 1;
                 iron +=5;
                 stone +=25;
                }else if(s.equals("iron")){
                    dia+=1;
                    iron +=1;
                    stone +=5;
                }else{
                    dia +=1;
                    iron +=1;
                    stone +=1;
                }
            if(j == minerals.length-1)
            {
                break;
            }
                }
           select[i/5][0] = dia;   
           select[i/5][1] = iron;
           select[i/5][2] = stone;
           dia =0;
           iron =0;
           stone =0;
            }
        Arrays.sort(select,(o1,o2)-> (o2[2]-o1[2]));
  
        for(int i =0; i<cnt;i++){
            if(picks[0]!=0){
                answer += select[i][0];
                picks[0]--;
            }
            else if(picks[1]!=0){
                answer += select[i][1];
                picks[1]--;
            }
            else if(picks[2]!=0){
                answer += select[i][2];
                picks[2]--;
            }            
        }
        
        
        return answer;
    }
}