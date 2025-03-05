import java.util.*;

public class Main{
    
    static int[][] graph;
    static boolean[] visited;
    static int count;
    static int N;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int number;
        int index = 0;
        graph = new int[N+1][N+1];
        while(true){
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();
            if(number1 == -1 && number2 == -1){
                break;
            }
            graph[number1][number2] = 1;
            graph[number2][number1] = 1;
        }
        sc.close();
        int[] score = new int[N+1];
        int min_num = N;
        for(int i = 1; i <= N; i++){
            score[i] = bfs(i);
            min_num = Math.min(min_num, score[i]);
        }
        int min_count = 0;
        for(int i = 1; i <= N; i++){
            if(score[i] == min_num){
                min_count++;
            }
        }
        
        System.out.println(min_num + " " + min_count);
        for(int i = 1; i <= N; i++){
            if(score[i] == min_num){
                System.out.print(i + " ");
            }
        }
    }
    
    public static int bfs(int s){
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[N+1];
        int[] depth = new int[N+1];
        
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i = 1; i <= N; i++){
                if(!visited[i] && graph[current][i] == 1){
                    q.add(i);
                    visited[i] = true;
                    depth[i] = depth[current] + 1;
                }
            }
        }
        return Arrays.stream(depth).max().getAsInt();
    }
}