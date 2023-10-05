package BOJ_17070_파이프옮기기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] home = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				home[i][j] = sc.nextInt();
		
		// 대각선은 cnt[0], 횡방향 cnt[1], 종방향 cnt[2]에 저장한다
		int[][][] cnt = new int[3][N][N];
		
		cnt[1][0][1] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (home[i][j] == 0) {
					
					// 1. 대각선으로 들어오는 파이프
					if (i > 0) {
						if (home[i-1][j] == 0 && home[i][j-1] == 0) {
							cnt[0][i][j] = cnt[0][i-1][j-1] + cnt[1][i-1][j-1] + cnt[2][i-1][j-1];
						}
					}
					
					// 2. 횡방향으로 들어오는 파이프
					cnt[1][i][j] = cnt[0][i][j-1] + cnt[1][i][j-1];
					
					// 3. 종방향으로 들어오는 파이프
					if (i > 0) {
						cnt[2][i][j] = cnt[0][i-1][j] + cnt[2][i-1][j];
					}
					
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < 3; i++) {
			answer +=cnt[i][N-1][N-1];
		}
		System.out.println(answer);
		
		sc.close();
	}
}