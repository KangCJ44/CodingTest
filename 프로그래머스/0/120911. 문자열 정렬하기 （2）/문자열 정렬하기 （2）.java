class Solution {
    public String solution(String my_string) {
        String answer = "";
        my_string = my_string.toLowerCase();
        char[] charArray = my_string.toCharArray();
        
        for(int i = 0; i < charArray.length - 1; i++){
            for(int j = i + 1; j < charArray.length; j++){
                if(charArray[j] < charArray[i]){
                    char temp = charArray[j];
                    charArray[j] = charArray[i];
                    charArray[i] = temp;
                }
            }
        }
        answer = new String(charArray);
        return answer;
    }
}