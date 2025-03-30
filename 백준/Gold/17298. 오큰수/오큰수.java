import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 현재 원소가 스택의 top에 해당하는 인덱스의 값보다 클 경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i]; // 오큰수를 현재 값으로 갱신
            }
            stack.push(i); // 현재 인덱스를 스택에 저장
        }

        // 스택에 남아 있는 인덱스는 오큰수가 없는 경우
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
