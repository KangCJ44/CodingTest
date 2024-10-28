class Solution {
    public double factorial(int n){
        double result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
    
    public int solution(int balls, int share) {
        int answer = 0;
        double numer = factorial(balls);
        double denom = factorial(share) * factorial(balls - share);
        answer = (int)Math.round((numer / denom));
        if(balls == share){
            answer = 1;
        }


        return answer;
    }
}