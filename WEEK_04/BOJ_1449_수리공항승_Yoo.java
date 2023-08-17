package BOJ_1449_�������׽�;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ������ �� ����
		int N = sc.nextInt();

		// ������ ���� ���Ѱ�����!
		int L = sc.nextInt();

		int[] arr = new int[N];
		// �¿찣�� 0.5 �ϴ� ����

		// �Է¹����ÿ�
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		// ó�� ������ ���̰� ����
		int cnt = 1;
		// ù ������ ����
		int A = arr[0];

		for (int i = 1; i < N; i++) {
			// �ִ� ������ �׳� ����
			if (arr[i] < A + L)
				continue;
			// ������ �Ѱ� �߰��ϰ� �������� ��ü
			else {
				cnt++;
				A = arr[i];
			}
		}

		System.out.println(cnt);
	}// ���ι�
}
