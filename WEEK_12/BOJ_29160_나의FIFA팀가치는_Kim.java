package WEEK_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 40m
public class BOJ_29160_나의FIFA팀가치는_Kim {
    static int playerNum; // 몇명의 선수
    static int year; // 년도
    static TreeMap<Integer, PriorityQueue<Integer>> pickPlayer; // 선발선수
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        playerNum = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
        pickPlayer = new TreeMap<>();
        answer = 0;

        // 입력
        for (int i = 1; i <= playerNum; i++) {
            st = new StringTokenizer(br.readLine());
            int player = Integer.parseInt(st.nextToken());

            // 있다면 pq 가져와서 넣기
            if (pickPlayer.containsKey(player)) {
                pickPlayer.get(player).add(Integer.parseInt(st.nextToken()));
                // 일단 처음에 정렬
                pickPlayer.get(player).comparator();
            } else {
                // 처음 생성하는거면 pq만들어서 넣어주기
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(Integer.parseInt(st.nextToken()));
                pickPlayer.put(player, pq);
            }
        } // 입력 끝

        // 1 ~ 11까지 중에 value가 없다면 공석으로 팀 구성
        for (int i = 1; i <= 11; i++) {
            if(!pickPlayer.containsKey(i)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(0);
                pickPlayer.put(i, pq);
            }
        }


        // 결국 년도가 반복 횟수
        for (int i = 0; i < year; i++) {
            // 3월에 3번 포지션 중 선수가치가 높은 선수가 선발 => 어차피 reverse로 넣으니까 ㄱㅊ ?
            // 8월에 가치 1 떨어짐

            for (int j = 1; j <= pickPlayer.size(); j++) {
                // 가장 앞에 있는게 선발선수니까 그거 -1, 근데 0보다 작아지지는 않으니까
                if (!pickPlayer.get(j).isEmpty() && pickPlayer.get(j).peek() > 0) {
                    pickPlayer.get(j).add(pickPlayer.get(j).poll() - 1);
                    pickPlayer.get(j).comparator();
                }
            }
        }
        for (int i = 1; i <= pickPlayer.size(); i++) {
            answer += pickPlayer.get(i).peek();
        }

        System.out.println(answer);
    }
}
