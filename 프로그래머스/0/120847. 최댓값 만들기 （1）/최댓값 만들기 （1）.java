class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > max1){
                max2 = max1;
                max1 = numbers[i];
            }
            else if(numbers[i] > max2){
                max2 = numbers[i];
            }
        }
        answer = max1 * max2;
        return answer;
    }
}