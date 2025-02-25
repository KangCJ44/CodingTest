import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] classes = new int[N][2];
        for(int i = 0; i < N; i++){
            classes[i][0] = sc.nextInt();
            classes[i][1] = sc.nextInt();
        }
        sc.close();
        
        Arrays.sort(classes, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classes[0][1]);
        
        for(int i = 1; i < N; i++){
            if(pq.peek() <= classes[i][0]){
                pq.poll();
            }
            pq.add(classes[i][1]);
        }
        System.out.println(pq.size());
    }
}