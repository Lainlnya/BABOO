package BOJ_28075_스파이;

import java.util.Scanner;

public class Main {
	/*
	 * 28075 스파이
	 * 얼마나 걸렸는지는 모르겠다..
	 * 
	 * Spy(String path) 메서드의 재귀를 이용해 풀었다.
	 * path는 각 날짜에 한 일의 번호를 String으로 받는다.
	 * Spy 메서드에서는 path의 길이가 N이 되기 전까지는 path를 생성한다.
	 * (0~5까지의 숫자를 뒤에 계속 붙여줌)
	 * 만약 path.length() == N 이 성립하면, 얻은 기여도를 계산한다.
	 * 첫 날 한 일을 path.charAT(0) - '0' 으로 받을 수 있다(아스키코드)
	 * 두번째 날 부터는 전날 한 일의 종류에 따라 기여도 계산이 달라진다.
	 * (path.charAt(i) - '0') % 3 == (path.charAt(i-1) - '0') % 3
	 * 이 성립하면, 얻을 수 있는 기여도의 절반만 얻는다.
	 * 이렇게 계산한 기여도가 M 이상일 때에는 변수 ans의 값을 1 늘린다.
	 * 재귀가 끝난 후 ans의 값을 출력한다.
	 */
	
	static int N, M;
	static String path;
	static int ans;
	static int[] scores = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		N = sc.nextInt(); // 며칠동안
		M = sc.nextInt(); // 최소 기여도
		
		for (int i = 0; i < 6; i++) {
			scores[i] = sc.nextInt();
		}
		
		ans = 0;
		Spy(""); // 재귀

		System.out.println(ans);
		sc.close();
	}

	public static void Spy(String path) {

		// 다 만들어 졌으면 만든 경우의 수에 대해 점수 계산
		if (path.length() == N) {
			int score = 0;
			score += scores[path.charAt(0) - '0'];
			for (int i = 1; i < path.length(); i++) {
				int yesterday = (path.charAt(i-1) - '0') % 3;
				if ((path.charAt(i) - '0') % 3 == yesterday) {
					score += scores[(path.charAt(i) - '0')] / 2;
				} else {
					score += scores[path.charAt(i) - '0'];
				}
			}
			
			if (score >= M) {
				ans++;
			}
			
			return;
		}
		
		// 가능한 경우의 수 모두 생성
		for (int today = 0; today < 6; today++) {
			Spy(path + today);
		}
		
	}
}