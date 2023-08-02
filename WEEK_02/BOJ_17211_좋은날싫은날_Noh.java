package BOJ;

import java.util.Scanner;

public class BOJ_S5_17211_좋은날싫은날 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N일 뒤 기분
		int N = sc.nextInt();
		// 오늘의 기분(0: 좋은 날, 1: 싫은 날)
		int tdy = sc.nextInt();
		// 좋은 날 > 좋은 날
		double gg = sc.nextDouble();
		// 좋은 날 > 싫은 날
		double gb = sc.nextDouble();
		// 싫은 날 > 좋은 날
		double bg = sc.nextDouble();
		// 싫은 날 > 싫은 날
		double bb = sc.nextDouble();
		// N일 까지의 확률 저장
		double[][] prob = new double[2][N];

		if (tdy == 0) {
			prob[0][0] = gg;
			prob[1][0] = gb;
		} else if (tdy == 1) {
			prob[0][0] = bg;
			prob[1][0] = bb;
		}
		
		// i번째 날 기분이 좋을 확률 = (i-1)번째 날 기분이 좋았을 확률 * gg + (i-1)번째 날 기분이 싫었을 확률 * bg
		// i번째 날 기분이 싫을 확률 = (i-1)번째 날 기분이 좋았을 확률 * gb + (i-1)번째 날 기분이 싫었을 확률 * bb
		for (int i = 1; i < N; i++) {
			prob[0][i] = prob[0][i - 1] * gg + prob[1][i - 1] * bg;
			prob[1][i] = prob[0][i - 1] * gb + prob[1][i - 1] * bb;
		}

		double ansg = prob[0][N - 1] * 1000;
		double ansb = prob[1][N - 1] * 1000;

		// N일 뒤에 기분이 좋은 날일 확률 * 1000
		System.out.printf("%.0f\n", ansg);
		// N일 뒤에 기분이 싫은 날일 확률 * 1000
		System.out.printf("%.0f", ansb);
	}
}
