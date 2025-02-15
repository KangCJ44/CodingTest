import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        
        for(int i = 0; i < time; i++){
            int x_1 = sc.nextInt();
            int y_1 = sc.nextInt();
            int r_1 = sc.nextInt();
            int x_2 = sc.nextInt();
            int y_2 = sc.nextInt();
            int r_2 = sc.nextInt();
            double d = Math.sqrt(Math.pow(x_2 - x_1, 2) + Math.pow(y_2 - y_1, 2));
            int result;
            if(d == 0 && r_1 == r_2){
                result = -1;
            }
            else if(d > r_2 + r_1 || d < Math.abs(r_1 - r_2)){
                result = 0;
            }
            else if(d == r_2 + r_1 || d == Math.abs(r_1 - r_2)){
                result = 1;
            }
            else{
                result = 2;
            }
            System.out.println(result);
        }
        sc.close();
    }
}