import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] vips = new int[M];
        
        for(int i = 0; i < M; i++){
            vips[i] = sc.nextInt();
        }
        
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= 40; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        int result = 1;
        int prev = 0;
        
        for(int i = 0; i < M; i++){
            int gap = vips[i] - prev - 1;
            result *= dp[gap];
            prev = vips[i];
        }
        
        result *= dp[N - prev];
        
        System.out.println(result);
    }
}