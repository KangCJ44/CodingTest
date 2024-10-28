class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int temp = 0;
        for(int i = 0; i < sides.length - 1; i++){
            for(int j = i + 1; j < sides.length; j++){
                if(sides[i] < sides[j]){
                    temp = sides[j];
                    sides[j] = sides[i];
                    sides[i] = temp;
                }
            }
        }
        if(sides[0] < sides[1] + sides[2]){
            answer = 1;
        }
        else{
            answer = 2;
        }
        return answer;
    }
}