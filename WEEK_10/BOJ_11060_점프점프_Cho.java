package BOJ_11060_Cho;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11060_점프점프_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] jNum = new int[N + 1]; //1부터 시작 점프점프 할수있는 범위 배열
		int[] dp = new int[N + 1]; //dp용 배열
		Arrays.fill(dp, 1000000); //MaxInteger로 하면 +1에서 음수값되서 적당히 값 정해줌
		for (int i = 1; i <= N; i++) {
			jNum[i] = sc.nextInt();
		}
		dp[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= i + jNum[i]; j++)
				if (j <= N)	
					dp[j] = Math.min(dp[j], dp[i] + 1);
		} //특정지점에서 갈 수 잇는 지점까지 모두 계샨
		if (dp[N] > 10000) //1000초과면 아무거나 상관없음
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}
