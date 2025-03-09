import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] costs = new int[N];
        
        for(int i = 0; i < N; i++){
            costs[i] = sc.nextInt();
        }
        
        int count = 0;
        
        for(int i = N-1; i >= 0; i--){
            if(k >= costs[i]){
                count += k / costs[i];
                k %= costs[i];
            }
        }
        
        System.out.println(count);
    }
}