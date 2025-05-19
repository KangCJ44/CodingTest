import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 파티 수

        int truthCount = sc.nextInt();
        boolean[] knowsTruth = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < truthCount; i++) {
            int person = sc.nextInt();
            knowsTruth[person] = true;
            queue.offer(person);
        }

        List<List<Integer>> parties = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                int person = sc.nextInt();
                party.add(person);
            }

            // 파티 참석자들끼리 양방향 연결
            for (int j = 0; j < party.size(); j++) {
                for (int k = j + 1; k < party.size(); k++) {
                    int a = party.get(j);
                    int b = party.get(k);
                    graph.get(a).add(b);
                    graph.get(b).add(a);
                }
            }

            parties.add(party);
        }

        // BFS로 진실 네트워크 전파
        boolean[] visited = new boolean[N + 1];
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    knowsTruth[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (knowsTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }
}
