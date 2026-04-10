import java.util.*;
class Solution {
     public boolean notDivisible(int[] arr, int num){
        for(int n : arr)
            if(n % num == 0)
                return false;
        return true;
    }
    
        public int getGcd(int a , int b){
            if(a%b ==0){
                return b;
            }
        return getGcd(b,a%b);
        }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i =1 ; i <arrayA.length;i++){
             gcdA = getGcd(gcdA,arrayA[i]);
             gcdB = getGcd(gcdB,arrayB[i]);
        }
        if(notDivisible(arrayB,gcdA)){
            if(answer<gcdA){
                answer = gcdA;
            }
        }
        if(notDivisible(arrayA,gcdB)){
            if(answer<gcdB){
                answer = gcdB;
            }
        }
        
        return answer;
    }
}