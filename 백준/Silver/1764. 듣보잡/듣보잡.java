import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        String[] checkList = new String[N];
        String[] list = new String[M];
        
        for(int i = 0 ; i < N; i++){
            checkList[i] = sc.nextLine();
        }
        for(int i = 0; i < M; i++){
            list[i] = sc.nextLine();
        }
        
        Arrays.sort(checkList);
        Arrays.sort(list);
        
        String[] result = new String[Math.min(N, M)];
        int count = 0;
        
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (checkList[i].equals(list[j])) {
                result[count++] = checkList[i];
                i++;
                j++;
            } else if (checkList[i].compareTo(list[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(count);
        for (int k = 0; k < count; k++) {
            System.out.println(result[k]);
        }
    }
}