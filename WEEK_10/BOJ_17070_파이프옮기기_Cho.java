package BOJ_17070_Cho;

import java.util.Scanner;

//������� ���̴� ���� 
//50������ ����� ���� queue�������� �׻� 100������ ������� ���ƾ� ��.
public class BOJ_17070_�������ű��_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] wall = new boolean[N][N];
		int[][] dpRow = new int[N][N]; // �� dp
		int[][] dpCol = new int[N][N]; // �� dp
		int[][] dpCross = new int[N][N]; // �밢�� dp
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sc.nextInt() == 1)
					wall[i][j] = true;
			}
		} // �� ���� 1�� dp�� �־�ξ� ������ �������� ǥ��
		dpRow[0][1] = 1;
		for (int i = 2; i < N; i++) {
			if (wall[0][i]) {
				break;
			}

			dpRow[0][i] = 1;

		} // �� ���� (����) ���� ���ٸ� ���� 1, �ִٸ� �� �ڷδ� 0
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (wall[i][j]) {

				} // i, j ������ ���̶�� 0 �� ����
				else {
					if (wall[i][j]) {

					} else {
						dpRow[i][j] = dpRow[i][j - 1] + dpCross[i][j - 1];
						dpCol[i][j] = dpCol[i - 1][j] + dpCross[i - 1][j];
						if (!wall[i][j - 1] && !wall[i - 1][j])
							dpCross[i][j] = dpRow[i - 1][j - 1] + dpCol[i - 1][j - 1] + dpCross[i - 1][j - 1];
						//�밢���� ������ �κ� Ȯ�ο� ���� ������쿡�� �밢�� ���� ���ϰ�, �ȸ��� ��쿡�� �밢�� dp�� ����.
					}
				}
			}

		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dpRow[i][j] + " ");
//
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dpCol[i][j] + " ");
//
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dpCross[i][j] + " ");
//
//			}
//			System.out.println();
//		} //������

		System.out.println(dpRow[N - 1][N - 1] + dpCol[N - 1][N - 1] + dpCross[N - 1][N - 1]);
		
	}
}
