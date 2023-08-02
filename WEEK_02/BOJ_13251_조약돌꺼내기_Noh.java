package BOJ;
import java.util.Scanner;

public class BOJ_S3_13251_조약돌꺼내기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int color = sc.nextInt(); // 조약돌 색상개수
		int[] pebble = new int[color]; // 색상별 조약돌 개수
		int N = 0; // 전체 조약돌 개수
		for (int i = 0; i < color; i++) {
			pebble[i] = sc.nextInt();
			N += pebble[i];
		}
		int K = sc.nextInt(); // 랜덤하게 K개 뽑음

		// 전체 경우의 수 (N개에서 K개 뽑는 수)
		double entire = 1;
		for (int i = 0; i < K; i++) {
			entire *= N - i;
		}
	

		// 뽑은 조약돌 K개가 모두 같은 색일 확률 구하기!
		double sum = 0;
		for (int i = 0; i < color; i++) {
			if (pebble[i] < K)
				continue;
			else {
				double tmp = 1;
				for (int j = 0; j < K; j++) {
					tmp *= (pebble[i] - j);
					System.out.println(tmp);
				}
				sum += tmp;
			}
		}
		double prob = (double) sum / entire;
		System.out.println(prob);
	}
}
