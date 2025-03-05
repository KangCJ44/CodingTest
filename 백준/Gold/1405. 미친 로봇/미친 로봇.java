import java.util.*;

public class Main{
    
    static int N;
    static double[] probs = new double[4];
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 동, 서, 남, 북
    static int[] dy = {0, 0, 1, -1};
    static double result = 0.0;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < 4; i++){
            probs[i] = sc.nextInt()/100.0;
        }
        sc.close();
        visited = new boolean[2*N + 1][2*N + 1];
        visited[N][N] = true;
        dfs(N, N, 0, 1.0);
        System.out.println(result);
    }
    
    public static void dfs(int x, int y, int step, double probability){
        if(step == N){
            result += probability;
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(!visited[nx][ny] && probs[i] > 0){
                visited[nx][ny] = true;
                dfs(nx, ny, step + 1, probability * probs[i]);
                visited[nx][ny] = false;
            }
        }
    }
}