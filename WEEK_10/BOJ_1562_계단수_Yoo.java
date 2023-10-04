package Study_1005;

import java.util.Scanner;

public class 계단수_1562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		// 나눌 수
		int mod = 1000000000;
		long ans = 0;

		// dp 배열 생성(자릿수, 현재 쓰인숫자, 숫자체크용비트)
		int[][][] dp = new int[101][10][1 << 10];

		// 초기 상태 설정
		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}

		// 자릿수
		for (int i = 2; i <= n; i++) {
			// 쓰이는 숫자 0-9
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < (1 << 10); k++) {
					//k에서 OR 계산을 통해 이전 비트 더해서 개수 파악 가능
					// k | 1 << j는 현재 자릿수 j를 사용했다는 표시
					if (j == 0) {
						dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j + 1][k]) % mod;
					} else if (j == 9) {
						dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j - 1][k]) % mod;
					} else
						dp[i][j][k | 1 << j] = (dp[i][j][k | 1 << j] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % mod;
				}
			}
		}
		
		//비트마스크 (1 << 10) - 1은 모든 숫자가 사용되었다는 표시
		for (int i = 0; i < 10; i++) {
			ans = (ans + dp[n][i][(1 << 10) - 1]) % mod;
		}
		System.out.println(ans);
	}
}

//https://sfer7.tistory.com/46
