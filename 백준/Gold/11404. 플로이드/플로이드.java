import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N][N];
        int INF = 1000000000;
        
        for(int i = 0; i < N; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        
        for(int i = 0; i < M; i++){
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            int c = sc.nextInt();
            
            graph[s][e] = Math.min(graph[s][e], c);
        }
        
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(graph[i][k] != INF && graph[k][j] != INF){
                        graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                    }
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == INF){
                    System.out.print("0 ");
                }
                else{
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}