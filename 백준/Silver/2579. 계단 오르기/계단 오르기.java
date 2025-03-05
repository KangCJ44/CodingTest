import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N + 1];
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++){
            score[i] = sc.nextInt();
        }
        if(N == 1){
            System.out.println(score[1]);
            return;
        }
        
        dp[1] = score[1];
        if (N >= 2) dp[2] = score[1] + score[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }
        System.out.println(dp[N]);
    }
}