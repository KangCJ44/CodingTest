import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();  // 물건의 수
        int K = sc.nextInt();  // 준서가 버틸 수 있는 최대 무게
        
        int[] W = new int[N + 1];  // 각 물건의 무게
        int[] V = new int[N + 1];  // 각 물건의 가치
        
        // 물건의 무게와 가치를 입력 받는다
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        
        // DP 테이블 선언
        int[][] dp = new int[N + 1][K + 1];
        
        // 동적 계획법 적용
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
                if (W[i] > w) {  // 물건을 넣을 수 없으면 이전 물건까지의 값을 그대로 가져온다
                    dp[i][w] = dp[i - 1][w];
                } else {  // 물건을 넣을 수 있으면, 넣지 않는 경우와 넣는 경우 중 더 큰 가치를 선택
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
                }
            }
        }
        
        // 결과 출력
        System.out.println(dp[N][K]);
    }
}