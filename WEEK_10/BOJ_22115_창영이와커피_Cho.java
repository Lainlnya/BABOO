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
				dp[i][j] = 150; //적당히 큰값으로 다 넣어두고 비교하면서 작은 값나오도록
		int max = 0;
		for (int i = 1; i <= N; i++) { //2차원 dp 그대로
			max += C[i]; // 해당커피까지 얻을수있는 최고 카페인 계산 
			for (int j = 1; j <= K; j++) {
				if (j - C[i] > 0) {
					if (j > max) //해당커피까지 얻을수있는 최고 카페인 넘을 경우 더 계산 안함
						break;
					dp[i][j] = Math.min(dp[i - 1][j - C[i]] + 1, dp[i - 1][j]); // 저번거랑 비교
				} else if (j - C[i] == 0)
					dp[i][j] = 1; //첫 커피마실수있으면 거기에 1기록
				else {
					dp[i][j] = dp[i-1][j];
					//커피가 얻을 수있는 카페인보다 적으면 저번 dp꺼 가져옴
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
		
		
		
		
		if (dp[N][K] >100)
			System.out.println(-1); //문제상 100넘을수없으므로 100넘으면 불가능
		else
			System.out.println(dp[N][K]);

	}
}
