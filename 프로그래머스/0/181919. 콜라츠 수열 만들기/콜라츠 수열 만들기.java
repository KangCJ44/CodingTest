import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[1];
        answer[0] = n;
        int count = 1;
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
                count++;
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[count - 1] = n;
            }
            else{
                n = 3 * n + 1;
                count++;
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[count - 1] = n;
            }
        }
        return answer;
    }
}