import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIndex = new HashMap<>();

        // players 배열로 선수의 이름과 현재 순위(인덱스)를 저장
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        // callings 배열의 각 추월을 처리
        for (String calling : callings) {
            // 추월한 선수의 현재 순위
            int currentIndex = playerIndex.get(calling);

            // 추월한 선수와 앞 선수 교환
            String previousPlayer = players[currentIndex - 1];
            players[currentIndex - 1] = calling;
            players[currentIndex] = previousPlayer;

            // 순위 업데이트
            playerIndex.put(calling, currentIndex - 1);
            playerIndex.put(previousPlayer, currentIndex);
        }

        return players;
    }
}