class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i = 0; i < my_string.length()/m; i++){
            answer += my_string.charAt(i*m+c-1);
        }
        return answer;
    }
}