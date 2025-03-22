import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] classes = new int[N][3];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++){
                classes[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        Arrays.sort(classes, (a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classes[0][2]);
        
        for(int i = 1; i < N; i++){
            if(pq.peek() <= classes[i][1]){
                pq.poll();
            }
            pq.add(classes[i][2]);
        }
        System.out.println(pq.size());
    }
}