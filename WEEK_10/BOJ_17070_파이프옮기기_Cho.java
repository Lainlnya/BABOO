package BOJ_17070_Cho;

import java.util.Scanner;

//사람간의 차이는 없음 
//50원가진 사람의 수가 queue관점에서 항상 100원가진 사람보다 많아야 함.
public class BOJ_17070_파이프옮기기_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] wall = new boolean[N][N];
		int[][] dpRow = new int[N][N]; // 행 dp
		int[][] dpCol = new int[N][N]; // 열 dp
		int[][] dpCross = new int[N][N]; // 대각선 dp
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sc.nextInt() == 1)
					wall[i][j] = true;
			}
		} // 빈 벽은 1로 dp에 넣어두어 지나갈 수없음을 표시
		dpRow[0][1] = 1;
		for (int i = 2; i < N; i++) {
			if (wall[0][i]) {
				break;
			}

			dpRow[0][i] = 1;

		} // ㅡ 방향 (맨위) 벽이 없다면 전부 1, 있다면 그 뒤로는 0
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (wall[i][j]) {

				} // i, j 지점이 벽이라면 0 값 냅둠
				else {
					if (wall[i][j]) {

					} else {
						dpRow[i][j] = dpRow[i][j - 1] + dpCross[i][j - 1];
						dpCol[i][j] = dpCol[i - 1][j] + dpCross[i - 1][j];
						if (!wall[i][j - 1] && !wall[i - 1][j])
							dpCross[i][j] = dpRow[i - 1][j - 1] + dpCol[i - 1][j - 1] + dpCross[i - 1][j - 1];
						//대각선시 막히는 부분 확인용 로직 막힐경우에는 대각선 빼고 더하고, 안막힌 경우에는 대각선 dp도 만듬.
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
//		} //디버깅용

		System.out.println(dpRow[N - 1][N - 1] + dpCol[N - 1][N - 1] + dpCross[N - 1][N - 1]);
		
	}
}
