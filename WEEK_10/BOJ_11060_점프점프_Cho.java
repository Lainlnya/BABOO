package BOJ_11060_Cho;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11060_점프점프_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] jNum = new int[N + 1]; //1부터 시작하기위해 하나 크게 만듬
		int[] dp = new int[N + 1]; //dp역시 마찬가지
		Arrays.fill(dp, 1000000); //MaxInteger로 하면 뒤쪽에 문제 생겨서 여기서 미리 전처리
		for (int i = 1; i <= N; i++) {
			jNum[i] = sc.nextInt();
		}
		dp[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= i + jNum[i]; j++)
				if (j <= N)	
					dp[j] = Math.min(dp[j], dp[i] + 1);
		} //내가 갈수 있는 모든 지점에 기록 최저값만 남김
		if (dp[N] > 10000) //1000이면 
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}
