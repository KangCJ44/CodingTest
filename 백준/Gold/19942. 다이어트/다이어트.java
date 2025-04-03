import java.util.*;

public class Main{
    
    static int N, mp, mf, ms, mv;
    static int[][] ingredients;
    static int minCost = Integer.MAX_VALUE;
    static List<Integer> bestCombi = new ArrayList<>();
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        mp = sc.nextInt();
        mf = sc.nextInt();
        ms = sc.nextInt();
        mv = sc.nextInt();
        
        ingredients = new int[N][5];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 5; j++){
                ingredients[i][j] = sc.nextInt();
            }
        }
        
        findCombination(0, 0, 0, 0, 0, 0, new ArrayList<>());
        
        if(minCost == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(minCost);
            for(int num : bestCombi){
                System.out.print(num + " ");
            }
        }
    }
    
    public static void findCombination(int index, int p, int f, int s, int v, int cost, List<Integer> selected){
        if(p >= mp && f >= mf && s >= ms && v >= mv){
            if(cost < minCost || (cost == minCost && compareList(selected, bestCombi))){
                minCost = cost;
                bestCombi = new ArrayList<>(selected);
            }
            return;
        }
        
        if(index >= N){
            return;
        }
        
        findCombination(index + 1, p, f, s, v, cost, selected);
        
        selected.add(index + 1);
        findCombination(index + 1, 
                        p + ingredients[index][0], 
                        f + ingredients[index][1], 
                        s + ingredients[index][2], 
                        v + ingredients[index][3], 
                        cost + ingredients[index][4],
                       selected);
        selected.remove(selected.size() - 1);
    }
    
    public static boolean compareList(List<Integer> a, List<Integer> b){
        if(b.isEmpty()) return true;
        
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        
        return a.size() < b.size();
    }
}