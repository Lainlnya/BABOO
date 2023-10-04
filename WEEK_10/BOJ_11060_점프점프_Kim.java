package WEEK_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11060_점프점프_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mazeNum = Integer.parseInt(br.readLine()); // 미로 개수
        int[] maze = new int[mazeNum]; // 미로 입력을 받기 위한 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mazeNum; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[mazeNum];

        dp[0] = 0; // 가장 처음은 점프하지 않으니까 0으로 초기화

        for (int i = 1; i < mazeNum; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                // dp를 구할 인덱스와 현재 인덱스에서 미로의 현재 인덱스를 더했을 때 i가 큰지를 확인
                // 1 2 0 1 3 2 1 5 4 2
                // 위를 예시로 들었을 때 2번째 나온 2의 경우 2만큼 뛰었을 때 가장 최소의 점프를 할 수 있기 때문
                // 그래서 i보다 크거나 같으면 dp[i]를 더해주는 형식으로 구함
                if (j + maze[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        if (dp[mazeNum - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(dp[mazeNum - 1]);
    }
}
