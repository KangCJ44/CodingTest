import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        for(int i = 0; i < time; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            long result = 1;
            for(int j = 0; j < N; j++){
                result *= (M - j);
                result /= (j + 1);
            }
            System.out.println(result);
        }
        sc.close();
    }
}