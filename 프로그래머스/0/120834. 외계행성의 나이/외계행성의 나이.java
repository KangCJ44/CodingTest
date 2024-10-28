class Solution {
    public String solution(int age) {
        String answer = "";
        String ageStr = String.valueOf(age);
        for(int i = 0; i < ageStr.length(); i++){
            int digit = ageStr.charAt(i) - '0';
            answer += ((char)('a' + digit));
        }
        return answer;
    }
}