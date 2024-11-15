class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        int[] answer = new int[2];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        for(String route : routes){
            String[] parts = route.split(" ");
            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);
            
            int newRow = answer[0];
            int newCol = answer[1];
            boolean isBlocked = false;
            
            for (int step = 1; step <= distance; step++) {
                if (direction.equals("N")) newRow--;
                if (direction.equals("S")) newRow++;
                if (direction.equals("W")) newCol--;
                if (direction.equals("E")) newCol++;

                // 공원 경계 확인
                if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
                    isBlocked = true;
                    break;
                }
                // 장애물 확인
                if (park[newRow].charAt(newCol) == 'X') {
                    isBlocked = true;
                    break;
                }
            }

            // 이동 가능할 경우 위치 갱신
            if (!isBlocked) {
                answer[0] = newRow;
                answer[1] = newCol;
            }
        }
        
        return answer;
    }
}