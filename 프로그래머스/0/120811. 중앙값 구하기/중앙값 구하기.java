class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int tmp;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[i]){
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        answer = array[array.length / 2];
        return answer;
    }
}