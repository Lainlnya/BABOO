package BOJ_22115_Cho;

import java.util.Scanner;

public class BOJ_22115_창영이와커피_Cho {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] C = new int[N + 1];
		for (int i = 1; i <= N; i++)
			C[i] = sc.nextInt();
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 0; i < N + 1; i++)
			for (int j = 1; j < K + 1; j++)
				dp[i][j] = 150; //적당한 불가능한 값 설정
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max += C[i];
			for (int j = 1; j <= K; j++) {
				if (j - C[i] > 0) {
					if (j > max)
						break;
					dp[i][j] = Math.min(dp[i - 1][j - C[i]] + 1, dp[i - 1][j]);
				} else if (j - C[i] == 0)
					dp[i][j] = 1;
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
//		for (int i = 0 ; i <=N ; i++) {
//			
//			for (int j = 0 ; j<=K; j++) {
//				System.out.print(dp[i][j] +" ");
//			}
//			System.out.println();
//		}
		//디버깅용
		
		
		
		if (dp[N][K] >100)
			System.out.println(-1); // 문제 조건상 100을 넘을 수 없으므로 넘는다는것은 불가능 의미
		else
			System.out.println(dp[N][K]);

	}
}
