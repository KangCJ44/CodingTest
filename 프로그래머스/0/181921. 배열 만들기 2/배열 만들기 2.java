import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 숫자 5부터 시작
        queue.add(5);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 숫자가 r보다 크면 이후 숫자들도 범위를 벗어나므로 종료
            if (current > r) continue;

            // 현재 숫자가 l 이상이고 0이 아니면 결과 리스트에 추가
            if (current >= l) {
                answer.add(current);
            }

            // 다음 자리의 0과 5를 추가하여 숫자 생성
            queue.add(current * 10);      // 0 추가
            queue.add(current * 10 + 5);  // 5 추가
        }

        // 결과가 비어있으면 -1을 포함하는 배열 반환
        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        // List를 int 배열로 변환하여 반환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}