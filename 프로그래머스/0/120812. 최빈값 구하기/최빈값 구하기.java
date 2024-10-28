class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] frequency = new int[1000];
        int maxfrequency = 0;
        boolean multiModes = false;
        
        for(int num : array){
            frequency[num]++;
        }
        
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] > maxfrequency){
                maxfrequency = frequency[i];
                answer = i;
                multiModes = false;
            }
            else if(frequency[i] == maxfrequency){
                multiModes = true;
            }
        }
        return multiModes ? -1 : answer;
    }
}