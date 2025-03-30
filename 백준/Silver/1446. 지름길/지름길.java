import java.util.*;

class Shortcut{
    int start, end, cost;
    
    Shortcut(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        
        List<Shortcut> shortcuts = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            
            if(end <= D && end - start > cost){
                shortcuts.add(new Shortcut(start, end, cost));
            }
        }
        
        int[] dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        for(int i = 0; i <= D; i++){
            if(i > 0){
                dist[i] = Math.min(dist[i-1] + 1, dist[i]);
            }
            
            for(Shortcut s : shortcuts){
                if(s.start == i && dist[i] + s.cost < dist[s.end]){
                    dist[s.end] = dist[s.start] + s.cost;
                }
            }
        }
        
        System.out.println(dist[D]);
    }
}