package src;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] d = new int[N - 1];
		int[] p = new int[N];
		for (int i = 0; i < N - 1; i++)
			d[i] = sc.nextInt(); // �Ÿ� �޾ƿ���
		for (int i = 0; i < N; i++)
			p[i] = sc.nextInt(); //������ ���� �޾ƿ���
		long min = p[0], ds = d[0]; //������ ó���� �����ؾ��ϹǷ� �ʱⰪ���� �Է�
		long result = 0;
		for (int i = 1; i < N - 1; i++) {
			if (min > p[i]) {
				result += Long.valueOf(min * ds); //������ �ּҰ� ���� �� �� �������� ���� �ּҰ� * �Ÿ� �����ֱ�
				min = p[i];
				ds = d[i];
			} else {
				ds += d[i]; // �� �����Ұ� �� �� ��쿡�� ��� ���ϱ�
			}

		}
		result += ds*min; // �������� �����ҿ��� �����Ͽ� �� �Ÿ��� �� ���������Ƿ� �����ֱ�
		System.out.println(result);
	}
}