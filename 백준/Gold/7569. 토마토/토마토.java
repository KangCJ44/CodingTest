import java.util.*;

public class Main{
    
    static int N, M, L;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] box;
    static int[][][] days;
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        L = sc.nextInt();
        
        box = new int[L][N][M];
        days = new int[L][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < L; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    box[i][j][k] = sc.nextInt();
                    if(box[i][j][k] == 1){
                        q.add(new int[]{i, j, k});
                        days[i][j][k] = 0;
                    }
                }
            }
        }
        sc.close();
        bfs(q);
        
        int maxDays = 0;
        for(int i = 0; i < L; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(box[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    maxDays = Math.max(maxDays, days[i][j][k]);
                }
            }
        }
        System.out.println(maxDays);
    }
    
    public static void bfs(Queue<int[]> q){
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int z = pos[0];
            int x = pos[1];
            int y = pos[2];
            
            for(int i = 0; i < 6; i++){
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nz < 0 || nz >= L || nx < 0 || nx >= N || ny < 0 || ny >= M){
                    continue;
                }
                
                if(box[nz][nx][ny] == 0){
                    box[nz][nx][ny] = 1;
                    days[nz][nx][ny] = days[z][x][y] + 1;
                    q.add(new int[]{nz, nx, ny});
                }
            }
        }
    }
}