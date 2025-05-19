import java.util.*;

public class Main{
    
    static int getOpposite(int idx){
        switch(idx){
            case 0: return 5;
            case 1: return 3;
            case 2: return 4;
            case 3: return 1;
            case 4: return 2;
            case 5: return 0;
        }
        return -1;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dice = new int[N][6];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 6; j++){
                dice[i][j] = sc.nextInt();
            }
        }
        
        int maxTotal = 0;
        
        for(int bottom = 0; bottom < 6; bottom++){
            int sum = 0;
            int bottomVal = dice[0][bottom];
            int top = getOpposite(bottom);
            int topVal = dice[0][top];
            sum += getMaxSide(dice[0], bottom, top);
            
            for(int i = 1; i < N; i++){
                int newBottom = 0;
                
                for(int j = 0; j < 6; j++){
                    if(dice[i][j] == topVal){
                        newBottom = j;
                        break;
                    }
                }
                int newTop = getOpposite(newBottom);
                bottomVal = dice[i][newBottom];
                topVal = dice[i][newTop];
                
                sum += getMaxSide(dice[i], newBottom, newTop);
            }
            maxTotal = Math.max(maxTotal, sum);
        }
        System.out.println(maxTotal);
    }
    
    static int getMaxSide(int[] dice, int bottom, int top){
        int max = 0;
        for(int i = 0; i < 6; i++){
            if(i == bottom || i == top){
                continue;
            }
            max = Math.max(dice[i], max);
        }
        return max;
    }
}