class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int min = 1000000;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if(arr[j] > queries[i][2] && arr[j] < min){
                    min = arr[j];
                }
            }
            answer[i] = (min == 1000000) ? -1 : min;
        }
        return answer;
    }
}