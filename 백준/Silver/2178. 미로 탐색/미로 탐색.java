import java.util.*;

public class Main{
    
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] maze;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N][M];
        visited = new boolean[N][M];
        sc.nextLine();
        
        for(int i = 0 ; i < N; i++){
            String line = sc.nextLine();
            for(int j = 0; j < M; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            //현재 위치
            int[] current = q.poll();
            
            if(current[0] == N - 1 && current[1] == M - 1){
                return current[2];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny] && maze[nx][ny] == 1){
                        q.add(new int[]{nx, ny, current[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}