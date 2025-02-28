import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        System.out.println(bfs(N, K));
    }
    
    public static int bfs(int N, int K){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            if(current[0] == K){
                return current[1];
            }
            
            if(current[0]*2 <= 100000 && !visited[current[0]*2]){
                q.add(new int[]{current[0]*2, current[1]});
                visited[current[0]*2] = true;
            }
            
            if(current[0] - 1 >= 0 && !visited[current[0] - 1]){
                q.add(new int[]{current[0]-1, current[1]+1});
                visited[current[0]-1] = true;
            }
            
            if(current[0] + 1 <= 100000 && !visited[current[0] + 1]){
                q.add(new int[]{current[0]+1, current[1]+1});
                visited[current[0]+1] = true;
            }
            
            
        }
        return -1;
    }
}