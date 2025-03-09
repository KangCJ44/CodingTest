import java.util.*;

public class Main{
    
    static int N;
    static int[][] graph;
    static boolean[] visited;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i = 0; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            
            graph[s][e] = 1;
            graph[e][s] = 1;
        }
        
        sc.close();
        int connection = 0;
        
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                connection++;
            }
        }
        
        System.out.println(connection);
    }
    
    public static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i = 1; i <= N; i++){
                if(graph[current][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}