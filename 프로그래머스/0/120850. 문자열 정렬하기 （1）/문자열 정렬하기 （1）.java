class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        int count = 0;
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isDigit(c)){
                count++;
            }
        }
        
        answer = new int[count];
        int n = 0;
        
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isDigit(c)){
                answer[n++] = Character.getNumericValue(c);
            }
        }
        for(int i = 0; i < answer.length - 1; i++){
            for(int j = i + 1; j < answer.length; j++){
                if(answer[i] > answer[j]){
                    int temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        return answer;
    }
}