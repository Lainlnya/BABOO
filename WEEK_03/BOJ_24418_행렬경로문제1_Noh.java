package WEEK_03;

import java.util.Scanner;

/* (1,1) >> (n,n) 경로의 수 중 가장 높은 점수 구하는 행렬 경로 문제
 * 오른쪽이나 아래쪽으로만 이동 가능
 * 경로의 점수: 방문한 칸에 있는 수들을 더한 값
 * 재귀 호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해보는 문제!
 */
public class BOJ_24418_행렬경로문제1_Noh{
	public static int rec_cnt = 0;
	public static int dp_cnt = 0;

	// 재귀 호출로 행렬 경로 문제 계산
	public static int matrix_path(int[][] m, int n) {
		return matrix_path_rec(m, n, n);
	}

	public static int matrix_path_rec(int[][] m, int i, int j) {
		if (i == 0 || j == 0) {
			rec_cnt++;
			return 0;
		} else {
			return (m[i][j] + Math.max(matrix_path_rec(m, i - 1, j), matrix_path_rec(m, i, j - 1)));
		}
	}

	// 동적 프로그래밍으로 행렬 경로 문제 계산
	public static int matrix_path_dp(int[][] m, int n) {
		int[][] dp = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = 0;
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				dp_cnt++;
				dp[i][j] = m[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
			}

		}
		return dp[n - 1][n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 행렬의 크기 n
		int n = sc.nextInt();
		// n * n 행렬
		int[][] m = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		matrix_path_rec(m, n, n);
		matrix_path_dp(m, n);
		System.out.print(rec_cnt + " " + dp_cnt);
	}
}
