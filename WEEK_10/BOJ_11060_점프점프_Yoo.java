package Study_1005;

import java.util.Arrays;
import java.util.Scanner;

public class 점프점프_11060 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] dp = new int[N];
		Arrays.fill(dp, 0);

		//N이 1이면 이동할 필요없음
		if (N == 1) {
			System.out.println(0);
		} else {

			int set = arr[0];

			//처음 arr 값에 대한 dp 초기 세팅
			for (int i = 0; i <= set; i++) {
				dp[i] += 1;
			}

			for (int i = 1; i < N; i++) {
				int find = arr[i];

				if (dp[i] == 0) {
					continue;
				}

				//거스름돈 처럼 가능한거면 최소값만 찾아서 갱신, 처음 방문이면 +1
				else {
					for (int j = 1; j <= find; j++) {
						if (i + j < N) {
							if (dp[i + j] == 0) {
								dp[i + j] = dp[i] + 1;
							} else {
								dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
							}
						}
					}
				}
			}
			
			if (dp[N - 1] == 0) {
				System.out.println("-1");
			} else {
				System.out.println(dp[N - 1]);
			}
		}
	}
}
