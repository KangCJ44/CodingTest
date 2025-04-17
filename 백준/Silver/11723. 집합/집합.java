import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int S = 0;
        for(int i = 0; i < N; i++){
            String cmd = sc.next();
            int x = 0;
            
            if(!cmd.equals("all") && !cmd.equals("empty")){
                x = sc.nextInt();
            }
            switch (cmd) {
                case "add":
                    S |= (1 << x);
                    break;
                case "remove":
                    S &= ~(1 << x);
                    break;
                case "check":
                    sb.append((S & (1 << x)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    S ^= (1 << x);
                    break;
                case "all":
                    S = (1 << 21) - 1; // 1~20 비트 ON
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}