import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();
        
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] check_arr = new int[length1+1][length2+1];
        
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    check_arr[i][j] = check_arr[i-1][j-1] + 1;
                }
                else{
                    check_arr[i][j] = Math.max(check_arr[i-1][j], check_arr[i][j-1]);
                }
            }
        }
        System.out.println(check_arr[length1][length2]);
    }
}