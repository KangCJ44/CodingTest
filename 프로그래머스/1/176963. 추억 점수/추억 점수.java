import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String, Integer> yearningMap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            yearningMap.put(name[i], yearning[i]);
        }
        answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++){
            int score = 0;
            for(String person : photo[i]){
                score += yearningMap.getOrDefault(person, 0);
            }
            answer[i] = score;
        }
        return answer;
    }
}