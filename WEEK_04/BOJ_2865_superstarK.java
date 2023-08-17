import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		double[] people = new double[N+1]; // 1���� idx 1�� ���� ���� n+1 ũ�� �迭�� ����
		people[0] = Double.MIN_VALUE;
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				int idx = sc.nextInt();
				double score = sc.nextDouble();
				people[idx] = Math.max(people[idx], score);
			} 
		} // �޾ƿ� ��ü data ��ȸ�ϸ鼭 ���� ū ���� ����, ��� �帣���� �ְ����� ������ ������� ��������
		Arrays.sort(people); // �޾ƿ� �ְ������� ���ؼ� sort
		double sumScore = 0;
		for (int i = N ; i > N-K ; i--) {
			sumScore += people[i];
		} // ���� ���� ������ ������� �ְ������� ���� ����
		System.out.printf("%.1f", sumScore); // �Ҽ��� 1�ڸ����� ���
	}
}
