package BOJ_29792_규칙적인보스돌이;

import java.util.Arrays;
import java.util.Scanner;

// 한 캐릭터 당 최대 15분, 최대 M개의 캐릭터만 
// 캐릭터가 보스에게 데미지를 넣으면 보스의 체력이 데미지 만큼 감소 -> 0되면 끝
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 보유한 캐릭터의 수
		int N = sc.nextInt();
		// 하루에 사용할 캐릭터의 수
		int M = sc.nextInt();
		// 보스의 가짓 수
		int K = sc.nextInt();

		// 각 캐릭터가 1초에 가하는 데미지 D
		long[] D = new long[N + 1];
		for (int i = 1; i < N + 1; i++) {
			D[i] = sc.nextLong();
		}
		// 오름차순 정렬
		Arrays.sort(D);

		// 각 보스의 체력 P
		long[] P = new long[K + 1];
		// 각 보스를 처치했을 때 드랍하는 메소 Q
		int[] Q = new int[K + 1];
		for (int i = 1; i < K + 1; i++) {
			P[i] = sc.nextLong();
			Q[i] = sc.nextInt();
		}

		// 하루에 얻을 수 있는 최대 메소
		int ans = 0;

		// 15분 = 900초
		int[][] dp = new int[K + 1][901];
		// 데미지가 큰 캐릭터부터 탐색
		for (int i = N; i > 0; i--) {
			// 최대 M개의 캐릭터만!
			if (M == 0)
				break;
			M--;
			for (int j = 1; j < K + 1; j++) {
				// i번째 캐릭터가 j번째 보스를 죽이는데 필요한 시간(초)
				int killTime = (int) Math.ceil((double) P[j] / D[i]);
				for (int t = 1; t < 901; t++) {
					// i번째 캐릭터가 보스를 죽일 수 없는 시간이면 그 전 보스를 죽이고 얻는 메소랑 같음
					if (t - killTime < 0)
						dp[j][t] = dp[j - 1][t];
					else
						dp[j][t] = Math.max(dp[j - 1][t], dp[j - 1][t - killTime] + Q[j]);
				}
			}
			ans += dp[K][900];
		}
		System.out.println(ans);
	} // main
} // class
