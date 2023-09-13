package WEEK_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산_Kim {
    static int total; // 전체 사람 수
    static int[][] relation; // 촌수를 계산하기 위한 배열
    static boolean[] visited; // 방문을 알기위한 배열
    static int answer; // 몇 번을 거쳐야 할지 더하기 위한 변수
    static int person1; // 찾아야할 사람 수 1
    static int person2; // 찾아야할 사람 수 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken()); // 찾아야 할 사람 수1
        person2 = Integer.parseInt(st.nextToken()); // 찾아야 할 사람 수2
        relation = new int[total + 1][total + 1]; // 총 1 ~ 9개
        visited = new boolean[total + 1];
        answer = -1;

        int conn = Integer.parseInt(br.readLine()); // 총 연결되어 있는 사람 수

        for (int i = 0; i < conn; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        dfs(person1, 0);

        System.out.println(answer);

    }

    public static void dfs(int startNum, int depth) {
        visited[startNum] = true;

        if (startNum == person2) {
            answer = depth;
        }

        for(int i = 1; i <= total; i++) {
            if (relation[i][startNum] == 1 && !visited[i]) {
                dfs(i, depth + 1);
            }
        }

    }
}
