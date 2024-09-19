import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> lostcheauk = new HashSet<Integer>();
        Set<Integer> ress = new HashSet<Integer>();
        for(int i : reserve){
            ress.add(i);
        }
        for(int i : lost){
            if(ress.contains(i)){
                ress.remove(i);
            }else{
                lostcheauk.add(i);
            }
        }
        for(Integer i : ress){
            if(lostcheauk.contains(i-1)){
                lostcheauk.remove(i-1);
            }else if(lostcheauk.contains(i+1)){
                lostcheauk.remove(i+1);
            }
        }
        
        return n-lostcheauk.size();
    }
}