import java.util.*;

public class Main{
    
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        
        map = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        int days = 0;
        
        while(true){
            visited = new boolean[N][N];
            boolean moved = false;
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j)){
                            moved = true;
                        }
                    }
                }
            }
            if(!moved){
                break;
            }
            days++;
        }
        
        System.out.println(days);
    }
    
    
    public static boolean bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>();
        
        q.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;
        
        int sum = map[x][y];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if(diff >= L && diff <= R){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        sum += map[nx][ny];
                    }
                }
            }
        }
        
        if(union.size() <= 1){
            return false;
        }
        
        int avg = sum / union.size();
        
        for(int[] pos : union){
            map[pos[0]][pos[1]] = avg;
        }
        
        return true;
    }
}