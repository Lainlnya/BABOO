package BOJ_13325_Cho;

import java.util.Scanner;

public class BOJ_13325_����Ʈ��_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int wSum = 0; //����ġ ��
		int maxNum = (int) Math.pow(2, k+1); //��ü Ʈ�� ���̸� �̿��� �迭 ũ�� ���
		int[] weight = new int[maxNum]; //����ġ ���
		int[] dp = new int[maxNum]; //�Ʒ����� ���οö󰡸鼭 ����ġ�� �� ��Ͽ�
		for (int i = 2; i < maxNum; i++)
			weight[i] = sc.nextInt(); //�޾ƿ���
		for (int i = maxNum / 2; i < maxNum; i++)
			dp[i] = weight[i]; // ���� ���� ���� �ִ� ���鿡 �ش��ϴ� ����ġ ���
		for (int i = maxNum / 2 - 1; i >= 1; i--) {
			dp[i] = weight[i]+ Math.max(dp[i * 2], dp[i * 2 + 1]); // �ڱ� �Ʒ� �� ����ġ �� ū�ɷ� �Ѵ� �Ȱ��� ������־�� �ϹǷ� �̷��� ���
			wSum += Math.max(dp[i*2],  dp[i*2+1]); //���� ���������� �� 1���� ���� // �ٸ� �Ѱ��� �ڵ�����dp[1]�� �����Ǿ� �������� ������
		}
		wSum += dp[1];
		System.out.println(wSum);
	}
}
