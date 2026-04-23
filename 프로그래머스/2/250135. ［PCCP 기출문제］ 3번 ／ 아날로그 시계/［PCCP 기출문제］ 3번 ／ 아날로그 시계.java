class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = toSecond(h1,m1,s1);
        int end = toSecond(h2,m2,s2);
        
        return count(end) - count(start) + (isAlarm(start)?1:0);
    }
    private int toSecond(int h, int m, int s){
        return h*3600 + m*60 + s;
    }
    
    private int count(int t){
        int hourMeet= (int)((long)t*719/43200);
        int minuteMeet =(int)((long)t*59/3600);
        int result = hourMeet+minuteMeet;
        if(t>=43200) result -=1;
        return result;
    } 
    private boolean isAlarm(int t){
        int h = t%43200;
        
        boolean secondMinute = (h*59)%3600 ==0;
        boolean secondHour = (h*719)%43200==0;
        return secondMinute || secondHour;
    }
}