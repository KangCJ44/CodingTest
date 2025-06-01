import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        
        List<Integer> pos = new ArrayList<>();
        pos.add(0);
        for(int i = 0; i < N; i++){
            pos.add(sc.nextInt());
        }
        pos.add(L);
        
        Collections.sort(pos);
        
        int left = 1;
        int right = L;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            
            for(int i = 1; i < pos.size(); i++){
                int dist = pos.get(i) - pos.get(i-1);
                count += (dist - 1) / mid;
            }
            
            if(count > M){
                left = mid + 1;
            }
            else{
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}