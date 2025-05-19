import java.util.*;

public class Main{
    
    static int N;
    static int[][] map;
    static int[][][] dp;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1][3];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        dp[1][2][0] = 1;
        
        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= N; c++){
                if(map[r][c] == 1) continue;
                
                if(c - 1 >= 1){
                    dp[r][c][0] += dp[r][c-1][0];
                    dp[r][c][0] += dp[r][c-1][2];
                }
                
                if(r - 1 >= 1){
                    dp[r][c][1] += dp[r-1][c][1];
                    dp[r][c][1] += dp[r-1][c][2];
                }
                
                if(r - 1 >= 1 && c - 1 >= 1){
                    if(map[r-1][c] == 0 && map[r][c-1] == 0){
                        dp[r][c][2] += dp[r-1][c-1][0];
                        dp[r][c][2] += dp[r-1][c-1][1];
                        dp[r][c][2] += dp[r-1][c-1][2];
                    }
                }
            }
        }
        
        int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(result);
    }
}