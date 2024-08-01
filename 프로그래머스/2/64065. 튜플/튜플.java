import java.util.*;
class Solution {
    public int[] solution(String s) {
         int[] answer = {};
        String [] a= s.split("\\},\\{");
        a[0]  = a[0].replaceAll("[{}]","");
        a[a.length-1]  = a[a.length-1].replaceAll("[{}]","");
        String [][] sam = new String[a.length][];
        for(int i = 0; i<a.length;i++){
           String []sa = a[i].split(",");
           sam[sa.length-1]=sa;
        }
            
        HashSet<String> ham  = new HashSet<String>();
        String[] g = new String[a.length];
        for(int i = 0 ; i<sam.length;i++){
            for(int j =0 ; j<sam[i].length;j++){
                if(!ham.contains(sam[i][j])){
                    g[i] = sam[i][j];
                    ham.add(sam[i][j]);
                }
            }
        }
        answer = new int[g.length];
        for(int i =0 ; i<g.length;i++){
            answer[i] = Integer.parseInt(g[i]);
        }
        return answer;
    }
}