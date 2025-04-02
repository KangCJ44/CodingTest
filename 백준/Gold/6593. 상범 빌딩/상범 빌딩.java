import java.util.*;

class Point {
    int l, r, c, time;

    public Point(int l, int r, int c, int time) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.time = time;
    }
}

public class Main{
    
    static int L, R, C;
    static char [][][] building;
    static boolean [][][] visited;
    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            
            if(L == 0 && R == 0 && C == 0){
                break;
            }
            
            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            
            Point start = null;
            Point end = null;
            
            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    String line = sc.next();
                    for(int k = 0; k < C; k++){
                        building[i][j][k] = line.charAt(k);
                        if(building[i][j][k] == 'S'){
                            start = new Point(i, j, k, 0);
                        }
                        if(building[i][j][k] == 'E'){
                            end = new Point(i, j, k, 0);
                        }
                    }
                }
            }
            int result = bfs(start, end);
            
            if(result == -1){
                System.out.println("Trapped!");
            }
            else{
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }
    
    public static int bfs(Point start, Point end){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.l][start.r][start.c] = true;
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            if (current.l == end.l && current.r == end.r && current.c == end.c) {
                return current.time;
            }
            
            for (int i = 0; i < 6; i++) {
                int nl = current.l + dl[i];
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                
                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (!visited[nl][nr][nc] && building[nl][nr][nc] != '#') {
                        visited[nl][nr][nc] = true;
                        queue.add(new Point(nl, nr, nc, current.time + 1));
                    }
                }
            }
        }
        return -1;
    }
}