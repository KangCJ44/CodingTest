import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String my_string) {
        List<String> suffixes = new ArrayList<>();

        // 모든 접미사를 리스트에 추가
        for (int i = 0; i < my_string.length(); i++) {
            suffixes.add(my_string.substring(i));
        }

        // 사전순 정렬
        Collections.sort(suffixes);

        // 리스트를 배열로 변환하여 반환
        return suffixes.toArray(new String[0]);
    }
}