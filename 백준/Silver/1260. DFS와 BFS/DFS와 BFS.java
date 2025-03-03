import java.util.*;

public class Main{
    
    static int[][] graph;
    static boolean[] visited;
    static int N;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int start_point = sc.nextInt();
        
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < T; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        dfs(start_point);
        System.out.println();
        bfs(start_point);
    }
    
    public static void dfs(int s){
        visited[s] = true;
        System.out.print(s + " ");
        for(int i = 1; i <= N; i++){
            if(graph[s][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    
    public static void bfs(int s){
        visited = new boolean[N+1];
        visited[s] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        while(!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for(int i = 1; i <= N; i++){
                if(graph[v][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}