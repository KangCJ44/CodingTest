class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for (char ch : my_string.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                // 대문자인 경우: 'A'의 인덱스는 0, 'B'는 1, ..., 'Z'는 25
                answer[ch - 'A']++;
            } else if (Character.isLowerCase(ch)) {
                // 소문자인 경우: 'a'의 인덱스는 26, 'b'는 27, ..., 'z'는 51
                answer[ch - 'a' + 26]++;
            }
        }
        return answer;
    }
}