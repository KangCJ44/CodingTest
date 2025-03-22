import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] table = new int[N][M];
        int[][] dp = new int[N][M];
        sc.nextLine();
        
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            for(int j = 0; j < M; j++){
                table[i][j] = line.charAt(j) - '0';
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(table[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        System.out.println(max*max);
    }
}