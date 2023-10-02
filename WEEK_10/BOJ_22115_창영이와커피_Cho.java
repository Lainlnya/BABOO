package BOJ_22115_Cho;

import java.util.Scanner;

public class BOJ_22115_â���̿�Ŀ��_Cho {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] C = new int[N + 1];
		for (int i = 1; i <= N; i++)
			C[i] = sc.nextInt();
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 0; i < N + 1; i++)
			for (int j = 1; j < K + 1; j++)
				dp[i][j] = 150; //������ ū������ �� �־�ΰ� ���ϸ鼭 ���� ����������
		int max = 0;
		for (int i = 1; i <= N; i++) { //2���� dp �״��
			max += C[i]; // �ش�Ŀ�Ǳ��� �������ִ� �ְ� ī���� ��� 
			for (int j = 1; j <= K; j++) {
				if (j - C[i] > 0) {
					if (j > max) //�ش�Ŀ�Ǳ��� �������ִ� �ְ� ī���� ���� ��� �� ��� ����
						break;
					dp[i][j] = Math.min(dp[i - 1][j - C[i]] + 1, dp[i - 1][j]); // �����Ŷ� ��
				} else if (j - C[i] == 0)
					dp[i][j] = 1; //ù Ŀ�Ǹ��Ǽ������� �ű⿡ 1���
				else {
					dp[i][j] = dp[i-1][j];
					//Ŀ�ǰ� ���� ���ִ� ī���κ��� ������ ���� dp�� ������
				}
			}
		}
//		for (int i = 0 ; i <=N ; i++) {
//			
//			for (int j = 0 ; j<=K; j++) {
//				System.out.print(dp[i][j] +" ");
//			}
//			System.out.println();
//		}
		
		
		
		
		if (dp[N][K] >100)
			System.out.println(-1); //������ 100�����������Ƿ� 100������ �Ұ���
		else
			System.out.println(dp[N][K]);

	}
}
