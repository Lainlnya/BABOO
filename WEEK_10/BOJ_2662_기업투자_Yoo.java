package Study_1005;

import java.util.Scanner;

public class 기업투자_2662 {

	static int N, M;
	static int[][] dp, info, invest;
	static int[] path;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 투자 금액
		N = sc.nextInt();
		// 투자가능 기업 개수
		M = sc.nextInt();

		dp = new int[N + 1][M + 1];
		info = new int[N + 1][M + 1];
		invest = new int[N + 1][M + 1];
		path = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int TRASH = sc.nextInt();
			for (int j = 1; j <= M; j++) {
				info[i][j] = sc.nextInt();
			}
		}

		// 현재 지정되는 기업 == j
		for (int j = 1; j <= M; j++) {
			// 현재 포인팅 하는 기업(j)에 투자할 금액
			for (int i = 0; i <= N; i++) {
				// j-1 기업에 투자한 금액
				for (int k = N - i; k >= 0; k--) {
					// j기업까지 i+k원을 투자한 이익보다
					// j-1기업까지 k원을 투자한 이익 + j기업에 i원을 투자한 금액이 더 크다면
					if (dp[i + k][j] < dp[k][j - 1] + info[i][j]) {
						dp[i + k][j] = dp[k][j - 1] + info[i][j];
						invest[i + k][j] = i; // 투자 액수 저장(경로를 추적하기 위해)
					}
				}
			}
		}

		// check
		System.out.println(dp[N][M]);

		getPath(N, M);
		for (int i = 1; i <= M; i++) {
			System.out.print(path[i]+" ");
		}

	}

	//n = 현재 남은 투자금액, m= index
	public static void getPath(int n, int m) {
		if (m == 0) {
			return;
		}
		path[m] = invest[n][m];
		getPath(n - path[m], m - 1);
	}

}
