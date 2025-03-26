import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];
        
        for(int i= 0; i < N; i++){
            coins[i] = sc.nextInt();
        }
        
        Arrays.sort(coins);
        
        int[] dp = new int[K+1];
        dp[0] = 1;
        
        for(int coin:coins){
            for(int j = coin; j <= K; j++){
                dp[j] += dp[j - coin];
            }
        }
        
        System.out.println(dp[K]);
    }
}