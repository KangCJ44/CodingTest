import java.util.*;

public class Main{
    
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] box;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        box = new int[N][M];
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        sc.close();
        
        int days = 0;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            days = Math.max(days, current[2]);
            
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny] && box[nx][ny] == 0){
                        q.add(new int[]{nx, ny, current[2]+1});
                        visited[nx][ny] = true;
                        box[nx][ny] = 1;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        
        System.out.println(days);
    }
    
}