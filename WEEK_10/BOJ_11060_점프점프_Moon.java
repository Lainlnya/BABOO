package BOJ_11060_점프점프;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N: 미로의 길이, maze: 미로에 쓰인 숫자들
		int N = sc.nextInt();
		int[] maze = new int[N];
		for (int i = 0; i < N; i++) maze[i] = sc.nextInt();
		
		// dp: 몇 번 점프해야 해당 칸에 도착할 수 있는지 기록하는 int 배열
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) dp[i] = Integer.MAX_VALUE/10;
		
		dp[0] = 0;
		// 맨 왼쪽부터 오른쪽까지
		for (int i = 0; i < N; i++) {
			// 해당 칸에 쓰인 숫자만큼
			for (int j = 0; j <= maze[i]; j++) {
				if (i+j < N && i+j > 0) {
					// 기록된 숫자보다 더 적은 점프 횟수로 도착할 수 있다면
					if (dp[i+j] > dp[i]+1)
						dp[i+j] = dp[i]+1;
				}
			}
		}
		
		// 값이 갱신되지 않았다면 도착할 수 없다는 뜻이므로 -1 출력
		if (dp[N-1] == Integer.MAX_VALUE/10)
			System.out.println(-1);
		else
			System.out.println(dp[N-1]);
		
		sc.close();
	}
}