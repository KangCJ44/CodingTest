import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        String bomb = sc.nextLine();
        sc.close();
        
        char[] result = new char[str.length()];
        int index = 0;
        
        for(char c : str.toCharArray()){
            result[index++] = c;
            
            if(index >= bomb.length()){
                boolean isMatch = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (result[index - bomb.length() + i] != bomb.charAt(i)) {
                        isMatch = false;
                        break;
                    }
                }
                
                if (isMatch) {
                    index -= bomb.length();
                }
            }
        }
        System.out.println(index == 0 ? "FRULA" : new String(result, 0, index));
    }
}