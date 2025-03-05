import java.util.*;

public class Main{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int limit = sc.nextInt();
        int[] durability = new int[2*N];
        for(int i = 0; i < 2*N; i++){
            durability[i] = sc.nextInt();
        }
        System.out.println(simulate(N, limit, durability));
    }
    
    public static int simulate(int N, int limit, int[] durability){
        int[] belt = Arrays.copyOf(durability, 2*N);
        boolean[] robots = new boolean[2*N];
        int count = 0;
        while(true){
            count++;
            
            // 1. 벨트 회전
            int temp = belt[2 * N - 1];
            System.arraycopy(belt, 0, belt, 1, 2 * N - 1);
            belt[0] = temp;
            
            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = false;
            robots[N - 1] = false; // 내리는 위치 도착 시 로봇 제거
            
            // 2. 로봇 이동
            for(int i = N - 2; i > 0; i--){
                if(robots[i] && !robots[i + 1] && belt[i + 1] > 0){
                    robots[i] = false;
                    robots[i + 1] = true;
                    belt[i + 1]--;
                }
            }
            robots[N-1] = false;
            
            // 3. 로봇 올리기
            if(belt[0] > 0){
                robots[0] = true;
                belt[0]--;
            }
            
            // 4. 내구도 확인
            int zero_count = 0;
            for(int i = 0; i < 2*N; i++){
                if(belt[i] == 0){
                    zero_count++;
                }
                if(zero_count >= limit){
                    return count;
                }
            }
        }
    }
}