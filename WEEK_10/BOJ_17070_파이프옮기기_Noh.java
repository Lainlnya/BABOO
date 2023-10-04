package BOJ_17070_파이프옮기기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 집의 크기
		int N = sc.nextInt();

		int[][] home = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				home[i][j] = sc.nextInt();
			}
		} // 집 입력받기 끝!

		// 가로 ([i][j-1]칸의 가로+대각선)
		int[][] dp1 = new int[N + 1][N + 1];
		// 세로 ([i-1][j]칸의 세로+대각선)
		int[][] dp2 = new int[N + 1][N + 1];
		// 대각선 ([i-1][j-1]칸의 가로+세로+대각선)
		int[][] dp3 = new int[N + 1][N + 1];

		dp1[1][2] = 1; // 초기화

		for (int i = 1; i < N + 1; i++) {
			for (int j = 3; j < N + 1; j++) {
				// 벽이 있으면 갈 수 없으니까 건너뜀
				if (home[i][j] == 1)
					continue;

				// 가로 ([i][j-1]칸의 가로+대각선)
				if (home[i][j - 1] == 0)
					dp1[i][j] = dp1[i][j - 1] + dp3[i][j - 1];
				// 세로 ([i-1][j]칸의 세로+대각선)
				if (home[i - 1][j] == 0)
					dp2[i][j] = dp2[i - 1][j] + dp3[i - 1][j];
				// 대각선 ([i-1][j-1]칸의 가로+세로+대각선)
				if (home[i][j - 1] == 0 && home[i - 1][j] == 0)
					dp3[i][j] = dp1[i - 1][j - 1] + dp2[i - 1][j - 1] + dp3[i - 1][j - 1];
			}
		}

		// 가로,세로,대각선으로 오는거 다 더하기!
		System.out.println(dp1[N][N] + dp2[N][N] + dp3[N][N]);
	} // main
} // class
