import java.util.*;

public class Main{
    
    static int N;
    static int M;
    static int[][] room;
    static boolean[][] cleaned;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int cleanCount = 0;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        room = new int[N][M];
        cleaned = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                room[i][j] = sc.nextInt();
            }
        }
        
        clean(r, c, d);
        System.out.println(cleanCount);
    }
    
    static void clean(int x, int y, int dir){
        if(!cleaned[x][y]){
            cleaned[x][y] = true;
            cleanCount++;
        }
        
        for(int i = 0; i < 4; i++){
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0 && !cleaned[nx][ny]){
                clean(nx, ny, dir);
                return;
            }
        }
        
        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        
        if(bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] == 0){
            clean(bx, by, dir);
        }
    }
}