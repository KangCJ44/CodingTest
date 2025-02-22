import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] tri = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= i; j++){
                tri[i][j] = sc.nextInt();
            }
        }
        
        int[][] Arr = new int[N][N];
        Arr[0][0] = tri[0][0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    Arr[i][j] = tri[i][j] + Arr[i-1][j];
                }
                else{
                    Arr[i][j] = Math.max(Arr[i-1][j], Arr[i-1][j-1]) + tri[i][j];                    
                }
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            result = Math.max(Arr[N-1][i], result);
        }
        
        System.out.println(result);
        sc.close();
    }
}