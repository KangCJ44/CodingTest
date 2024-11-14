class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String temp = "";
        int index = 0;
        for(int i = e; i >= s; i--){
            temp += my_string.charAt(i);
        }
        
        for(int i = 0; i < s; i++){
            answer += my_string.charAt(i);
        }
        for(int i = 0; i < temp.length(); i++){
            answer += temp.charAt(index++);
        }
        for(int i = e + 1; i < my_string.length(); i++){
            answer += my_string.charAt(i);
        }
        return answer;
    }
}