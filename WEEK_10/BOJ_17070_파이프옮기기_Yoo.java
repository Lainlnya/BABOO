package Study_1005;

import java.util.Scanner;

public class 파이프옮기기1_17070 {

	static int N;
	static int[][] house;
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		//dp에서는 가 , 세 , 대 표시용 1차원 추가
		dp = new int[N + 1][N + 1][3];
		house = new int[N + 1][N + 1];
		
		//입력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				house[i][j] = sc.nextInt();
			}
		}

		// 시작
		dp[1][2][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 벽 만나면 안돼
				if (house[i][j] == 1)
					continue;

				// 가로가 되는 경우
				dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
				
				//세로가 되는 경우
				dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];

				// 벽 아닌거 확인되면 대각선 가능
				if (house[i - 1][j] == 0 && house[i][j - 1] == 0) {
					dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}
