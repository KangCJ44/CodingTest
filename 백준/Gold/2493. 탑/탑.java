import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        Stack<Tower> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 현재 탑보다 낮은 탑은 전부 제거
            while (!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek().index; // 수신한 탑의 번호 기록
            } else {
                result[i] = 0; // 수신하는 탑이 없음
            }

            stack.push(new Tower(i + 1, height)); // 현재 탑 스택에 추가
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append(' ');
        }
        System.out.println(sb);
    }
}
