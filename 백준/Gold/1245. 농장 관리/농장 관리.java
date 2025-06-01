import java.util.*;

public class Main{
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        int peakCount = 0;
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] > 0){
                    if(bfs(i, j)){
                        peakCount++;
                    }
                }
            }
        }
        System.out.println(peakCount);
    }
    
    public static boolean bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        boolean isPeak = true;
        int height = map[x][y];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i< 8; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx >= N || nx < 0 || ny >= M || ny < 0){
                    continue;
                }
                
                if(map[nx][ny] > height){
                    isPeak = false;
                }
                
                if(!visited[nx][ny] && map[nx][ny] == height){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return isPeak;
    }
}