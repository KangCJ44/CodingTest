import java.util.*;

public class Main{
    
    static int N, M;
    static int max;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        buildWall(0);
        
        System.out.println(max);
    }
    
    public static void buildWall(int count){
        if(count == 3){
            max = Math.max(max, getSafeZone());
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(graph[i][j] == 0){
                    graph[i][j] = 1;
                    buildWall(count+1);
                    graph[i][j] = 0;
                }
            }
        }
    }
    
    public static int getSafeZone(){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++){
            temp[i] = graph[i].clone();
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        return safeZone;
    }
}