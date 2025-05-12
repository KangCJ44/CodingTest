import java.util.*;

public class Main{
    
    static int N;
    static int[][] S;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                S[i][j] = sc.nextInt();
            }
        }
        
        int total = 1 << N;
        
        for(int bit = 0; bit < total; bit++){
            if(Integer.bitCount(bit) == 0 || Integer.bitCount(bit) == N)
                continue;
            
            List<Integer> teamLink = new ArrayList<>();
            List<Integer> teamStart = new ArrayList<>();
            
            for(int i = 0; i < N; i++){
                if((bit & (1 << i)) != 0){
                    teamStart.add(i);
                }
                else{
                    teamLink.add(i);
                }
            }
            
            int startNum = getTeamAbility(teamStart);
            int linkNum = getTeamAbility(teamLink);
            min = Math.min(min, Math.abs(startNum - linkNum));
        }
        System.out.println(min);
    }
    
    public static int getTeamAbility(List<Integer> team){
        int sum = 0;
        for(int i = 0; i < team.size(); i++){
            for(int j = 0; j < team.size(); j++){
                if(i != j){
                    sum += S[team.get(i)][team.get(j)];
                }
            }
        }
        return sum;
    }
}