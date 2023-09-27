package BOJ_11060_Cho;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11060_��������_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] jNum = new int[N + 1]; //1���� �����ϱ����� �ϳ� ũ�� ����
		int[] dp = new int[N + 1]; //dp���� ��������
		Arrays.fill(dp, 1000000); //MaxInteger�� �ϸ� ���ʿ� ���� ���ܼ� ���⼭ �̸� ��ó��
		for (int i = 1; i <= N; i++) {
			jNum[i] = sc.nextInt();
		}
		dp[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= i + jNum[i]; j++)
				if (j <= N)	
					dp[j] = Math.min(dp[j], dp[i] + 1);
		} //���� ���� �ִ� ��� ������ ��� �������� ����
		if (dp[N] > 10000) //1000�̸� 
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}
