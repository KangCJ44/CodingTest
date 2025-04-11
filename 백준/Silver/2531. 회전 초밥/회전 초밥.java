import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] sushi = new int[N];
        
        for(int i = 0; i < N; i++){
            sushi[i] = sc.nextInt();
        }
        
        int[] count = new int[d + 1];
        int unique = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0){
                unique++;
            }
            count[sushi[i]]++;
        }

        int max = unique + (count[c] == 0 ? 1 : 0);

        int start = 0;
        for (int i = 1; i < N; i++) {
            int remove = sushi[start];
            count[remove]--;
            if (count[remove] == 0){
                unique--;
            }

            int add = sushi[(i + k - 1) % N];
            if (count[add] == 0){
                unique++;
            }
            count[add]++;

            int total = unique + (count[c] == 0 ? 1 : 0);
            max = Math.max(max, total);

            start++;
        }

        System.out.println(max);
    }
}