import java.util.*;

public class BOJ_13251_조약돌꺼내기_Yoo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 조약돌 색 종류

		double[] arr = new double[M];

		int total = 0; // 총 조약돌 개수

		// N 번 숫자 배열로 입력받음
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		int K = sc.nextInt(); // 랜덤 K개 뽑기

		double prob = 0;
		for (int i = 0; i < M; i++) {
			double probl = 1;
			for (int j = 0; j < K; j++) {
				probl *= (arr[i] - j) / (total - j);
			}
			prob += probl;
		}

		System.out.println(prob);

	}
}
