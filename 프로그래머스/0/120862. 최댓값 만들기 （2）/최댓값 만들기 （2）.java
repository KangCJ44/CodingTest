class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int max_num = Integer.MIN_VALUE;
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i != j){
                    if(numbers[i] * numbers[j] > max_num){
                        max_num = numbers[i] * numbers[j];
                    }
                }
            }

        }
        answer = max_num;
        return answer;
    }
}