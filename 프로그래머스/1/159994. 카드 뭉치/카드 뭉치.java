class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0, j = 0; // cards1과 cards2의 포인터

        for (String word : goal) {
            if (i < cards1.length && cards1[i].equals(word)) {
                i++;
            } else if (j < cards2.length && cards2[j].equals(word)) {
                j++;
            } else {
                return "No"; // 원하는 순서대로 만들 수 없는 경우
            }
        }

        return "Yes"; // 모든 단어가 순서대로 사용된 경우
    }
}