class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        StringBuilder sb = new StringBuilder(my_string);
        
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            
            // 구간을 뒤집고 다시 설정
            String reversedSub = new StringBuilder(sb.substring(s, e + 1)).reverse().toString();
            sb.replace(s, e + 1, reversedSub);
        }
        return sb.toString();
    }
}