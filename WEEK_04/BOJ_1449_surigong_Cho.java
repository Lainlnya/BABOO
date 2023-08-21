import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int L = sc.nextInt() - 1; //�� �� 0.5�� �ǹ̰� ���⿡ 1���� ���� ����
		int[] boomArr = new int[N]; //N ���� �迭 ����
		int max = 0;
		for (int i = 0; i < N; i++) {
			boomArr[i] = sc.nextInt(); // ���� ������ ���
			max = Math.max(max, boomArr[i]); //���� �ִ� ���� ���
		}

		int[] lengArr = new int[max + 1]; // ������ ���̱� ���� ���� �ִ� ���������� �迭 ����
		for (int i = 0; i < N; i++)
			lengArr[boomArr[i]] = 1; // ���� �� �κе� ���
		
		int count = 0;
		for (int i = 1; i <= max; i++) {
			if (lengArr[i] == 1) {
				count++; //�շ��ִ� �κ� ������ ������ 1�� �߰�
				for (int j = i; j <= i + L; j++) {
					if (j <= max)
						lengArr[j] = 0; // ������ ���̸�ŭ�� ���� ��� ������ ���� => 0 ó��
				}
			}

		}
		System.out.println(count);
	}
}
