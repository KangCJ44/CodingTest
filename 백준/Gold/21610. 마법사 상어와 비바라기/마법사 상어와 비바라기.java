import java.util.*;

public class Main{

    static int N, M;
    static int[][] map;
    static boolean[][] cloud, copyCloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        cloud = new boolean[N+1][N+1];
        copyCloud = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        cloud[N][1] = cloud[N][2] = cloud[N-1][1] = cloud[N-1][2] = true;

        for(int i = 0; i < M; i++){
            int d = sc.nextInt();
            int s = sc.nextInt();

            moveCloud(d, s);
            cloudDiag();
            makeCloud();
        }

        System.out.println(total());
    }

    public static void moveCloud(int d, int s){
        boolean[][] newCloud = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(cloud[i][j]){
                    int ni = (i + dx[d] * s % N + N - 1) % N + 1;
                    int nj = (j + dy[d] * s % N + N - 1) % N + 1;
                    map[ni][nj]++;
                    copyCloud[ni][nj] = true;
                    newCloud[ni][nj] = true;
                }
            }
        }
        cloud = newCloud;
    }

    public static void cloudDiag(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(copyCloud[i][j]){
                    int waterCount = 0;
                    for(int k = 2; k <= 8; k += 2){
                        int di = i + dx[k];
                        int dj = j + dy[k];
                        if(di >= 1 && di <= N && dj >= 1 && dj <= N && map[di][dj] > 0){
                            waterCount++;
                        }
                    }
                    map[i][j] += waterCount;
                }
            }
        }
    }

    public static void makeCloud(){
        boolean[][] newCloud = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(!copyCloud[i][j] && map[i][j] >= 2){
                    map[i][j] -= 2;
                    newCloud[i][j] = true;
                }
                copyCloud[i][j] = false;
            }
        }
        cloud = newCloud;
    }

    public static int total(){
        int total = 0;
        for(int i = 1; i <= N; i++){
            for(int j= 1; j <= N; j++){
                total += map[i][j];
            }
        }
        return total;
    }
}
