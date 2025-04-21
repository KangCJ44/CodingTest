import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        System.out.println(z(N, r, c));
    }
    
    public static int z(int n, int r, int c){
        if(n == 0) return 0;
        
        int half = 1 << (n - 1);
        int area = half * half;

        if (r < half && c < half) {
            return z(n - 1, r, c);
        } else if (r < half && c >= half) {
            return area + z(n - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * area + z(n - 1, r - half, c);
        } else {
            return 3 * area + z(n - 1, r - half, c - half);
        }
    }
}