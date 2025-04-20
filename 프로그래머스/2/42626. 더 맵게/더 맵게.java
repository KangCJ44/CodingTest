import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mixCount = 0;
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int first = pq.poll();
            int second = pq.poll();
            
            int next = first + (second * 2);
            
            pq.offer(next);
            mixCount++;
        }
        
        answer = pq.peek() >= K ? mixCount : -1;
        return answer;
    }
}