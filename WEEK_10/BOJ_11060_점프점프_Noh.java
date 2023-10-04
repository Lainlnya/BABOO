package BOJ_11060_점프점프;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 미로의 크기
		int N = sc.nextInt();

		int[] maze = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			maze[i] = sc.nextInt();
		} // 입력받기 끝

		// i칸에 도착하기 위한 최소 점프수
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		// 가장 왼쪽 끝이 출발
		dp[1] = 0;

		for (int i = 1; i < N + 1; i++) {
			if (dp[i] >= Integer.MAX_VALUE)
				break;
			for (int j = 1; j <= maze[i]; j++) {
				// N번째 칸 까지만 궁금!
				if (i + j < N + 1)
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}

		if (dp[N] >= Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}
