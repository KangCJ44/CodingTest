import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int arr[] = {a, b, c, d};
        
        Arrays.sort(arr);
        if(arr[0] == arr[3]){
            answer = 1111 * arr[0];
        }
        else if(arr[0] == arr[2] || arr[1] == arr[3]){
            int p = arr[2];
            int q = arr[3] + arr[0] - arr[2];
            answer = (int) Math.pow(10 * p + q, 2);
        }
        else if(arr[0] == arr[1] && arr[2] == arr[3]){
            answer = (arr[0] + arr[2]) * (arr[2] - arr[0]);
        }
        else if (arr[0] == arr[1]) {
            answer = arr[2] * arr[3];  // 두 다른 숫자의 곱을 반환
        }
        else if (arr[1] == arr[2]) {
            answer = arr[0] * arr[3];  // 두 다른 숫자의 곱을 반환
        }
        else if (arr[2] == arr[3]) {
            answer = arr[0] * arr[1];  // 두 다른 숫자의 곱을 반환
        }
        
        // 모든 숫자가 다를 때
        // 예: [1, 2, 3, 4]
        else {
            answer = arr[0];  // 가장 작은 숫자를 반환
        }
        return answer;
    }
}