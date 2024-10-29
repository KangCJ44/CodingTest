class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long minTime = 0;
        long maxTime = (long) 1e15;
        long answer = maxTime;
        while(minTime <= maxTime){
            long midTime = (minTime + maxTime) / 2;
            long totalGold = 0;
            long totalSilver = 0;
            long totalCombined = 0;
            
            for(int i = 0; i < g.length; i++){
                long maxRoundTrips = midTime / (2 * t[i]);
                if(midTime % (2 * t[i]) >= t[i]){
                    maxRoundTrips++;
                }
                
                long maxTransport = maxRoundTrips * w[i];
                long transportGold = Math.min(g[i], maxTransport);
                long transportSilver = Math.min(s[i], maxTransport);
                long transportCombined = Math.min(g[i] + s[i], maxTransport);

                totalGold += transportGold;
                totalSilver += transportSilver;
                totalCombined += transportCombined;
            }
             if (totalGold >= a && totalSilver >= b && totalCombined >= a + b) {
                answer = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }
        return answer;
    }
}