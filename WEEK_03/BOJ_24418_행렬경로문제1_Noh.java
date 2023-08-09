package WEEK_03;

import java.util.Scanner;

/* (1,1) >> (n,n) 경로의 수 중 가장 높은 점수 구하는 행렬 경로 문제
 * 오른쪽이나 아래쪽으로만 이동 가능
 * 경로의 점수: 방문한 칸에 있는 수들을 더한 값
 * 재귀 호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해보는 문제!
 */
public class BOJ_24418_행렬경로문제1_Noh {
	public static int rec_cnt = 1;
	public static int dp_cnt = 0;

	// 재귀 호출로 행렬 경로 문제 계산
	public static int matrix_path_rec(int[][] m, int i, int j) {
		if (i == 0 && j == 0) {
			rec_cnt++;
			return 0;
		} else if (i == 0) {
			rec_cnt++;
			return (m[0][j] + matrix_path_rec(m, 0, j - 1));
		} else if (j == 0) {
			rec_cnt++;
			return (m[i][0] + matrix_path_rec(m, i - 1, 0));
		}

		else {
			rec_cnt++;
			return (m[i][j] + Math.max(matrix_path_rec(m, i - 1, j), matrix_path_rec(m, i, j - 1)));
		}
	}

	// 동적 프로그래밍으로 행렬 경로 문제 계산
	public static int matrix_path_dp(int[][] m, int n) {
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i - 1 <= 0 || j - 1 <= 0) {
					dp_cnt++;
					continue;
				} else {
					dp_cnt++;
					dp[i][j] = m[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n - 1][n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 행렬의 크기 n
		int n = sc.nextInt();
		// n * n 행렬
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		matrix_path_rec(m, n - 1, n - 1);
		matrix_path_dp(m, n);
		System.out.print(rec_cnt + " " + dp_cnt);
	}
}
