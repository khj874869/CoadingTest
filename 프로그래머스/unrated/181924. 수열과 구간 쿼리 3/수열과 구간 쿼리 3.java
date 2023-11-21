class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int E = 0;
        for(int i =0 ; i < queries.length;i++){
            E = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = E;
        }
        
        return arr;
    }
}