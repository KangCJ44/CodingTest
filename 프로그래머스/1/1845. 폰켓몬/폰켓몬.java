import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> kinds = new HashSet<>();
        
        for(int num : nums){
            kinds.add(num);
        }
        
        int maxPick = nums.length/2;
        
        answer = Math.min(maxPick, kinds.size());
        
        return answer;
    }
}