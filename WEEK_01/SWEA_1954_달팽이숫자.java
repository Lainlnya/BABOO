package SWEA;

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 방향(우 > 하 > 좌 > 상)
		int dr[] = { 0, 1, 0, -1 };
		int dc[] = { 1, 0, -1, 0 };

		for (int cnt = 1; cnt < T + 1; cnt++) {
			int N = sc.nextInt();
			int[][] ans = new int[N][N]; // N*N 크기의 배열 생성
			int r = 0; // 행 index
			int c = 0; // 열 index
			int num = 1; //
			int idx = 0; // 방향 조건

			while (num <= N * N) {
				ans[r][c] = num++;
				int nr = r + dr[idx];
				int nc = c + dc[idx];
				// 배열 경계를 벗어나거나 이미 숫자가 들어가 있으면 방향 전환
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || ans[nr][nc] != 0) {
					idx = (idx + 1) % 4;
					nr = r + dr[idx];
					nc = c + dc[idx];
				}
				r = nr;
				c = nc;
			}

			System.out.println("#" + cnt);
			for (int i = 0; i < N; i++) {
				for (int n : ans[i])
					System.out.print(n + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
