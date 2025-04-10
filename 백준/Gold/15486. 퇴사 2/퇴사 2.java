import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] table = new int[N][2];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                table[i][j] = sc.nextInt();
            }
        }
        
        int[] dp = new int[N+1];
        
        for(int i = N - 1; i >= 0; i--){
            if(i + table[i][0] <= N){
                dp[i] = Math.max(dp[i+1], table[i][1] + dp[i + table[i][0]]);
            }
            else{
                dp[i] = dp[i+1];
            }
            
        }
        
        System.out.println(dp[0]);
    }
}