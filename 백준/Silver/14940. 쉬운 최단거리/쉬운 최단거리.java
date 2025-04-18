import java.util.*;

public class Main{
    
    static int n, m;
    static int count = 0;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new ArrayDeque<>();
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(distance[i], -1);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2){
                    visited[i][j] = true;
                    q.add(new int[]{i, j, count});
                }
                else if(map[i][j] == 0){
                    distance[i][j] = 0;
                }
            }
        }
        
        bfs();
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void bfs(){
        while(!q.isEmpty()){
            int[] current = q.poll();
            distance[current[0]][current[1]] = current[2];
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(!visited[nx][ny]){
                        if(map[nx][ny] == 0){
                            visited[nx][ny] = true;
                        }
                        else{
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, current[2] + 1});
                        }
                    }
                }
            }
        }
    }
}