import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String tiktok = sc.nextLine();
            
            if(tiktok.equals("end")){
                break;
            }
            
            System.out.println(isValid(tiktok));
        }
    }
    
    public static String isValid(String tiktok){
        int xCount = 0, oCount = 0;
        char[] boardArray = tiktok.toCharArray();
        
        for (char c : boardArray) {
            if (c == 'X') xCount++;
            else if (c == 'O') oCount++;
        }
        
        if (!(xCount == oCount || xCount == oCount + 1)) {
            return "invalid";
        }
        
        boolean xWin = isWinner(boardArray, 'X');
        boolean oWin = isWinner(boardArray, 'O');
        
        if (xWin && oWin) {
            return "invalid";
        }
        
        if (xWin && xCount != oCount + 1) {
            return "invalid";
        }
        
        if (oWin && xCount != oCount) {
            return "invalid";
        }
        
        if (!xWin && !oWin && tiktok.contains(".")) {
            return "invalid";
        }
        
        return "valid";
    }
    
     public static boolean isWinner(char[] board, char player) {
        int[][] winCases = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로
            {0, 4, 8}, {2, 4, 6}  // 대각선
        };
        
        for (int[] winCase : winCases) {
            if (board[winCase[0]] == player && board[winCase[1]] == player && board[winCase[2]] == player) {
                return true;
            }
        }
        return false;
    }
}