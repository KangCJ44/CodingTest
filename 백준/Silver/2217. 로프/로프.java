import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ropes = new int[N];
        
        for(int i = 0; i < N; i++){
            ropes[i] = sc.nextInt();
        }
        
        Arrays.sort(ropes);
        int max_weight = 0;
        
        for(int i = 0; i < N; i++){
            int weight = ropes[i] * (N - i);
            if(max_weight < weight){
                max_weight = weight;
            }
        }
        System.out.println(max_weight);
        sc.close();
    }
}