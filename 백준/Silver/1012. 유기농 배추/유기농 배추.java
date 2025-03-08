import java.util.*;

public class Main{
    
    static int M, N;
    static boolean[][] visited;
    static int[][] field;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();
            field = new int[M][N];
            visited = new boolean[M][N];
            for(int j = 0; j < K; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[x][y] = 1;
            }
            int worm_count = 0;
            
            for(int j = 0; j < M; j++){
                for(int k = 0; k < N; k++){
                    if(field[j][k] == 1 && !visited[j][k]){
                        dfs(j, k);
                        worm_count++;
                    }
                }
            }
            System.out.println(worm_count);
        }
    }
    
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                if(field[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }
    }
}