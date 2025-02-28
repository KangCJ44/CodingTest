import java.util.*;

public class Main{
    
    static String str1;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        str1 = sc.next();
        String str2 = sc.next();
        sc.close();
        
        System.out.println(delete_Char(str2));
    }
    
    public static int delete_Char(String str){
        if(str1.equals(str)){
            return 1;
        }
        
        if(str.length() <= str1.length()){
            return 0;
        }
        
        if(str.charAt(str.length() - 1) == 'A'){
            String nextStr = str.substring(0, str.length() - 1);
            if(delete_Char(nextStr) == 1){
                return 1;
            }
        }
        
        if(str.charAt(0) == 'B'){
            String nextStr = new StringBuilder(str.substring(1)).reverse().toString();
            if(delete_Char(nextStr) == 1){
                return 1;
            }
        }
        return 0;
    }
}