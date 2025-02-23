import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        int Mod = 1000000000;
        long[][] chart = new long[N+1][10];
        
        //한자리 수는 다 1로 초기화
        for(int i = 1; i <= 9; i++){
            chart[1][i] = 1;
        }
        
        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    chart[i][j] = chart[i-1][1] % Mod;
                }
                else if(j == 9){
                    chart[i][j] = chart[i-1][8] % Mod;
                }
                else{
                    chart[i][j] = (chart[i-1][j-1] + chart[i-1][j+1]) % Mod;
                }
            }
        }
        long result = 0;
        for(int i = 0; i <= 9; i++){
            result = (result + chart[N][i]) % Mod;
        }
        System.out.println(result);
    }
}