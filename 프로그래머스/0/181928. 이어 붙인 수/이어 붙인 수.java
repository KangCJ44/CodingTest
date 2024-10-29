class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int odd = 0;
        int even = 0;
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                even = Integer.parseInt(even + "" + num_list[i]);
            }
            else{
                odd = Integer.parseInt(odd + "" + num_list[i]);
            }
            answer = odd + even;
        }
        return answer;
    }
}