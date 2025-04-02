import java.util.*;

public class Main {
    
    static int N;
    static int sharkSize = 2;
    static int canEat = 0;
    static int eatCount = 2;
    static int[][] graph;
    static int x, y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 9){
                    x = i;
                    y = j;
                    graph[i][j] = 0;  // 상어 위치 초기화
                }
            }
        }
        
        canEatCheck();
        
        if(canEat == 0){
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }
    
    public static void canEatCheck(){
        canEat = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] < sharkSize && graph[i][j] > 0){
                    canEat++;
                }
            }
        }
    }
    
    public static int bfs(){
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {  // 거리가 같으면
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]); // 위쪽 우선
                return Integer.compare(a[0], b[0]); // 왼쪽 우선
            }
            return Integer.compare(a[2], b[2]); // 가까운 거리 우선
        });

        pq.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        int result = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int cx = current[0], cy = current[1], distance = current[2];

            // 먹을 수 있는 물고기라면 먹기
            if (graph[cx][cy] > 0 && graph[cx][cy] < sharkSize) {
                eatCount--;
                canEat--;
                graph[cx][cy] = 0;
                x = cx;
                y = cy;
                result = distance;

                if (eatCount == 0) {
                    sharkSize++;
                    eatCount = sharkSize;
                    canEatCheck();
                }

                pq.clear();
                visited = new boolean[N][N];
                visited[x][y] = true;
            }

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] <= sharkSize) {
                    visited[nx][ny] = true;
                    pq.add(new int[]{nx, ny, distance + 1});
                }
            }
        }
        return result;
    }
}
