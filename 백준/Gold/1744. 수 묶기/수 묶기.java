import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++){
            numbers[i] = sc.nextInt();
        }
        sc.close();
        
        System.out.println(maxPair(numbers, N));
    }
    
    public static int maxPair(int[] numbers, int N){
        int[] positive = new int[N];
        int[] negative = new int[N];
        int posCount = 0, negCount = 0, zeroCount = 0, oneCount = 0;
        for(int number : numbers){
            if(number > 1){
                positive[posCount++] = number;
            }
            else if(number == 1){
                oneCount++;
            }
            else if(number == 0){
                zeroCount++;
            }
            else{
                negative[negCount++] = number;
            }
        }
        
        Arrays.sort(positive, 0, posCount);
        Arrays.sort(negative, 0, negCount);
        
        int maxSum = oneCount;
        
        // 양수 그룹 짝지어 처리 (큰 수부터 곱하기)
        for (int i = posCount - 1; i > 0; i -= 2) {
            maxSum += positive[i] * positive[i - 1];
        }
        if (posCount % 2 == 1) {
            maxSum += positive[0];
        }
        
        // 음수 그룹 짝지어 처리 (작은 수부터 곱하기)
        for (int i = 0; i < negCount - 1; i += 2) {
            maxSum += negative[i] * negative[i + 1];
        }
        if (negCount % 2 == 1) {
            maxSum += (zeroCount > 0) ? 0 : negative[negCount - 1];
        }
        
        return maxSum;
    }
}