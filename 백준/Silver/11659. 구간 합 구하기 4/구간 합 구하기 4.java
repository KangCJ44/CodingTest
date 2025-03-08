import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int arr[] = new int[N+1];
        int prefixsum[] = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
            prefixsum[i] = prefixsum[i - 1] + arr[i];
        }
        for(int i = 0; i < M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(prefixsum[e] - prefixsum[s-1]);
        }
        sc.close();
    }
}