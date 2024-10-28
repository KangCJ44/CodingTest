class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
         int numeric = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        // 분자와 분모의 최대공약수(GCD)를 구함
        int gcd = getGCD(numeric, denom);
        
        // 분자와 분모를 GCD로 나누어 기약분수로 변환
        numeric /= gcd;
        denom /= gcd;
        
        answer = new int[]{numeric, denom};
        
        // 결과를 배열로 반환
        return answer;
    }
    
    // 최대공약수를 구하는 함수 (유클리드 호제법)
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}