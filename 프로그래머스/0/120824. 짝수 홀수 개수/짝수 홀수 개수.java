class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even_count = 0;
        int odd_count = 0;
        
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                even_count++;
            }
            else{
                odd_count++;
            }
        }
        answer[0] = even_count;
        answer[1] = odd_count;
        return answer;
    }
}