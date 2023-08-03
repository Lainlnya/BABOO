import java.util.*;

public class BOJ_13251_���൹������_Yoo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // ���൹ �� ����

		double[] arr = new double[M];

		int total = 0; // �� ���൹ ����

		// N �� ���� �迭�� �Է¹���
		for (int i = 0; i < M; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		int K = sc.nextInt(); // ���� K�� �̱�

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
