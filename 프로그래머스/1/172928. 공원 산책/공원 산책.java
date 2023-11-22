import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int robotRow = -1;
        int robotColumn = -1;
        
        int rowNum = park.length;
        int columnNum = park[0].length();
            
        char [][] parkArray = new char[rowNum][columnNum];
        
        for (int i=0 ; i< rowNum; i++) { 
            String rowData = park[i];
            for (int j=0 ; j<columnNum ;j++) { 
                
                char locationData = rowData.charAt(j);
                parkArray[i][j] = locationData;
                
                if (locationData == 'S') {
                    robotRow = i;
                    robotColumn = j;
                }
            }
        }
        Map<Character, List<Integer>> dirMove = new HashMap<Character, List<Integer>>();
        dirMove.put('E', List.of(0,1));
        dirMove.put('W', List.of(0,-1));
        dirMove.put('N', List.of(-1,0));
        dirMove.put('S', List.of(1,0));
        

        for (String route : routes) {
            
            char direction = route.charAt(0);
            Integer move = route.charAt(2) - '0';
            
            int tmpRow = robotRow;
            int tmpColumn = robotColumn;
            
            Boolean possible = true;
            
            for (int i=0; i<move; i++) {
                
                Integer moveRow = robotRow + dirMove.get(direction).get(0);
                Integer moveColumn = robotColumn + dirMove.get(direction).get(1);
                if ( 0 > moveRow || moveRow >= rowNum || 0 > moveColumn || moveColumn >= columnNum) {
                    possible = false;
                    break;
                }

                if (parkArray[moveRow][moveColumn] == 'X') {
                    possible = false;
                    break;
                }
            
                parkArray[moveRow][moveColumn] = 'S';
                parkArray[robotRow][robotColumn] = 'O';
            
                robotRow = moveRow;
                robotColumn = moveColumn;
            }
                if (possible == false) {
                robotRow = tmpRow ;
                robotColumn = tmpColumn;
            }
        }
        int[] answer = new int[2];
        answer[0] = robotRow;
        answer[1] = robotColumn;
        return answer;
    }
}