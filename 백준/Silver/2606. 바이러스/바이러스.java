import java.util.*;

public class Main{
    
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;
    static int N;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        int M = sc.nextInt();
        
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 0; i < M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        dfs(1);
        System.out.println(count-1);
    }
    
    public static void dfs(int node){
        visited[node] = true;
        count++;
        
        for(int i = 1; i <= N; i++){
            if(graph[node][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}