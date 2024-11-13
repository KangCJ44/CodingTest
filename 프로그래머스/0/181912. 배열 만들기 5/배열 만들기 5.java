class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        int count = 0;
        for(int i = 0; i < intStrs.length; i++){
            String num = "";
            for(int j = s; j < s+l; j++){
                char c = intStrs[i].charAt(j);
                num += c;
            }
            if(Integer.valueOf(num).intValue() > k){
                count++;
            }
        }
        
        answer = new int[count];
        int index = 0;
        
        for(int i = 0; i < intStrs.length; i++){
            String num = "";
            for(int j = s; j < s+l; j++){
                char c = intStrs[i].charAt(j);
                num += c;
            }
            if(Integer.valueOf(num).intValue() > k){
                answer[index] = Integer.valueOf(num).intValue();
                index++;
            }
        }
        return answer;
    }
}