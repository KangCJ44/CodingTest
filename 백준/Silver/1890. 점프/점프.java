import java.util.*;

public class Main{
    
    static int N;
    static int[][] map;
    static long[][] dp_table;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp_table = new long[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        dp_table[0][0] = 1;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dp_table[i][j] == 0 || map[i][j] == 0) continue;
                if(i == N - 1 && j == N - 1) continue;
                
                int value = map[i][j];
                
                if(i+value < N){
                    dp_table[i+value][j] += dp_table[i][j];
                }
                if(j+value < N){
                    dp_table[i][j+value] += dp_table[i][j];
                }
            }
        }
        System.out.println(dp_table[N-1][N-1]);
    }
}