import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(graph[i], 1000000);
            graph[i][i] = 0;
        }
        
        for(int i = 0; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            
            graph[s][e] = 1;
            graph[e][s] = 1;
        }
                
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if (graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
        int minSum = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += graph[i][j];
            }

            if (sum < minSum) {
                minSum = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}