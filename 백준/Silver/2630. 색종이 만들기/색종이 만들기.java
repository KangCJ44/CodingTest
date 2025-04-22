import java.util.*;

public class Main{
    
    static int[][] paper;
    static int white = 0;
    static int blue = 0;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                paper[i][j] = sc.nextInt();
            }
        }
        countColor(0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    public static void countColor(int row, int col, int size){
        if(isSameColor(row, col, size)){
            if(paper[row][col] == 0){
                white++;
            }
            else{
                blue++;
            }
            return;
        }
        
        int newSize = size/2;
        
        countColor(row, col, newSize);
        countColor(row+newSize, col, newSize);
        countColor(row, col+newSize, newSize);
        countColor(row+newSize, col+newSize, newSize);
    }
    
    public static boolean isSameColor(int row, int col, int size){
        int color = paper[row][col];
        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(paper[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}