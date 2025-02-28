import java.util.*;

public class Main{
        
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            System.out.println(dp(N));
        }
        sc.close();
    }
    
    public static int dp(int N){
        int[][] table = new int[N+1][3+1];
        if(N <= 3){
            return N;
        }
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= i; j++){
                table[i][j] = 1;
            }
        }
        for (int i = 4; i <= N; i++) {
            table[i][1] = 1;  // 첫 번째 열은 1로 초기화
            table[i][2] = i / 2; // 두 번째 열은 N을 2로 나눈 값 (문제에 맞는 방식으로 수정)
            int num3 = 0;
            
           
            if (i - 3 >= 1) {
                for (int j = 1; j <= 3; j++) {
                    num3 += table[i - 3][j];
                }
            }
            table[i][3] = num3;
        }
        int result = 0;
        for(int i = 1; i <= 3; i++){
            result += table[N][i];
        }
        return result;
    }
}