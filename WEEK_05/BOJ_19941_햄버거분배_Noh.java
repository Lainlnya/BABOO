package BOJ_19941_햄버거분배;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 식탁의 길이
		int K = sc.nextInt(); // 햄버거를 선택할 수 있는 거리
		char[] hbg = new char[N];
		// 먹은 햄버거 > 1로 , 사람은 2로 저장
		int[] visited = new int[N];
		String str = sc.next();

		for (int i = 0; i < N; i++) {
			hbg[i] = str.charAt(i);
			if (hbg[i] == 'P')
				visited[i] = 2;
		} // 입력받기 끝

		int ans = 0; // 햄버거를 먹을 수 있는 최대 사람 수

		for (int i = 0; i < N; i++) {
			// 사람일 때
			if (hbg[i] == 'P') {
				// 양 옆으로 K개 확인해서
				for (int j = -K; j <= K; j++) {
					// 먹을 수 있는 햄버거면
					if (i + j >= 0 && i + j <= N - 1 && visited[i + j] == 0) {
						// 먹고 탈출!
						visited[i + j] = 1;
						ans++;
						break;
					}
				}
			}
		}

		System.out.println(ans);
	}
}
