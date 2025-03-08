import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            pq.add(sc.nextInt());
        }
        sc.close();
        
        int total = 0;
        
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            total += sum;
            pq.add(sum);
        }
        
        System.out.println(total);
    }
}