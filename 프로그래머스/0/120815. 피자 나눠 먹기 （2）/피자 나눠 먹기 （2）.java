class Solution {
    public int solution(int n) {
        int answer = 0;
        int gcd = gcd(6, n); // 6과 n의 최대공약수 계산
        answer = (n * 6) / gcd / 6; // 최소공배수(LCM)을 이용하여 필요한 피자 판 수 계산
        return answer;
    }
    
    // 최대공약수(GCD)를 구하는 함수 (유클리드 호제법 사용)
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}