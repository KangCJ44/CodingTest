import java.util.*;

public class Main{
    
    static int N, K;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int s = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        sc.close();
        
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                System.out.print(isBlack(i, j) ? "1" : "0");
            }
            System.out.println();
        }
    }
    
    public static boolean isBlack(int r, int c){
        while(r > 0 || c > 0){
            if((r % N) >= (N - K) / 2 && (r % N) < (N + K) / 2
              && (c % N) >= (N - K) / 2 && (c % N) < (N + K) / 2){
                return true;
            }
            r /= N;
            c /= N;
        }
        return false;
    }
}