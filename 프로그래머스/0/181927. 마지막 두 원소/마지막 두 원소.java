class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int index = 0;
        for(int i = 0; i < num_list.length; i++){
            answer[i] = num_list[i];
            index++;
        }
        if(num_list[index - 1] > num_list[index - 2]){
            answer[index] = num_list[index - 1] - num_list[index - 2];
        }
        else{
            answer[index] = num_list[index - 1] * 2;
        }
        return answer;
    }
}