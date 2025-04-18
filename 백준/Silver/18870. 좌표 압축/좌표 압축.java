import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 속도 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 속도 향상
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] sort_nums = new int[N];

        // 공백으로 구분된 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sort_nums[i] = nums[i];
        }

        Arrays.sort(sort_nums);
        int[] unique = Arrays.stream(sort_nums).distinct().toArray();

        // 값 -> 압축된 좌표 맵핑
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < unique.length; i++) {
            map.put(unique[i], i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(nums[i])).append(" ");
        }

        // 결과 한번에 출력
        System.out.println(sb);
    }
}
