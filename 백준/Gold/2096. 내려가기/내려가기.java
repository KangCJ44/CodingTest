import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] nums = new int[N][3];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        
        int[][] min_table = new int[N][3];
        int[][] max_table = new int[N][3];
        
        for (int j = 0; j < 3; j++) {
            min_table[0][j] = nums[0][j];
            max_table[0][j] = nums[0][j];
        }
        
        for(int i = 1; i < N; i++){
            min_table[i][0] = Math.min(min_table[i-1][0], min_table[i-1][1]) + nums[i][0];
            min_table[i][1] = Math.min(Math.min(min_table[i-1][0], min_table[i-1][1]), min_table[i-1][2]) + nums[i][1];
            min_table[i][2] = Math.min(min_table[i-1][1], min_table[i-1][2]) + nums[i][2];

            max_table[i][0] = Math.max(max_table[i-1][0], max_table[i-1][1]) + nums[i][0];
            max_table[i][1] = Math.max(Math.max(max_table[i-1][0], max_table[i-1][1]), max_table[i-1][2]) + nums[i][1];
            max_table[i][2] = Math.max(max_table[i-1][1], max_table[i-1][2]) + nums[i][2];
        }
        
        int min_result = Math.min(min_table[N-1][0], Math.min(min_table[N-1][1], min_table[N-1][2]));
        int max_result = Math.max(max_table[N-1][0], Math.max(max_table[N-1][1], max_table[N-1][2]));
        
        System.out.println(max_result + " " + min_result);
    }
}