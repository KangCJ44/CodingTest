import java.util.*;

public class Main{
    
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    houses.add(new int[]{i, j});
                }
                else if(map[i][j] == 2){
                    chickens.add(new int[]{i, j});
                }
            }
        }
        combination(0, 0, new int[M]);
        
        System.out.println(minDistance);
    }
    
    public static void combination(int start, int depth, int[] selected){
        if(depth == M){
            minDistance = Math.min(minDistance, calculateDistance(selected));
            return;
        }
        
        for(int i = start; i < chickens.size(); i++){
            selected[depth] = i;
            combination(i + 1, depth + 1, selected);
        }
    }
    
    public static int calculateDistance(int[] selected){
        int sum = 0;
        for(int[] house : houses){
            int hx = house[0];
            int hy = house[1];
            int min = Integer.MAX_VALUE;
            for(int idx : selected){
                int[] chicken = chickens.get(idx);
                int cx = chicken[0];
                int cy = chicken[1];
                int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                min = Math.min(min, dist);
            }
            sum += min;
        }
        return sum;
    }
}