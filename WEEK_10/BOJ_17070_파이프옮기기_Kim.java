package WEEK_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int pipeWidth = Integer.parseInt(br.readLine());

        int[][] pipe = new int[pipeWidth][pipeWidth];
        // 1차원: 가로, 2차원: 세로, 3차원: 대각선
        int[][][] dp = new int[pipeWidth][pipeWidth][3];
        dp[0][1][0] = 1; // 최초로 놓여진 지점

        int answer = 0;

        for (int i = 0; i < pipeWidth; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < pipeWidth; j++) {
                pipe[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < pipeWidth; i++) {
            for (int j = 1; j < pipeWidth; j++) {
                // 우선 1이면 못감
                if (pipe[i][j] == 1) {
                    continue;
                }
                // 가로: 가로 + 대각선
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];

                // 세로: 세로 + 대각선
                if (i != 0) {
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                // 대각선으로 이동할 수 없는 케이스
                if (i - 1 >= 0 && (pipe[i - 1][j] == 1 || pipe[i][j - 1] == 1)) continue;

                // 대각선: 가로 + 세로 + 대각선
                if (i - 1 >= 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            answer += dp[pipeWidth - 1][pipeWidth - 1][i];
        }

        System.out.println(answer);
    }
}
