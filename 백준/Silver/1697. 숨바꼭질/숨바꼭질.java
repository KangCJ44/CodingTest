import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        System.out.println(bfs(N, M));
    }
    
    public static int bfs(int N, int M){
        if(N == M)
            return 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N, 0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(current[0] == M){
                return current[1];
            }
            
            int[] nextPos = {current[0] - 1, current[0] + 1, current[0] * 2};
            
            for(int next : nextPos){
                if(next >= 0 && next <= 100000 && !visited[next]){
                    if(next == M){
                        return current[1] + 1;
                    }
                    queue.add(new int[]{next, current[1] + 1});
                    visited[next] = true;
                }
                
            }
        }
        return -1;
    }
}