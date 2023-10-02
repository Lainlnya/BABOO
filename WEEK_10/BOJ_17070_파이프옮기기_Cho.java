package BOJ_17070_Cho;

import java.util.Scanner;


public class BOJ_17070_�������ű��_Cho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] wall = new boolean[N][N];
		int[][] dpRow = new int[N][N]; // 세로 dp
		int[][] dpCol = new int[N][N]; //  가로 dp
		int[][] dpCross = new int[N][N]; // 대각선 dp
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sc.nextInt() == 1)
					wall[i][j] = true;
			}
		} // 벽은 미리 true로 만들어 지나갓다는 설정으로 해둠
		dpRow[0][1] = 1;
		for (int i = 2; i < N; i++) {
			if (wall[0][i]) {
				break;
			} 

			dpRow[0][i] = 1;

		} //첫째줄 dp 기본 설정 벽만나면 그 뒤는 더이상 못가므로 0 
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (wall[i][j]) {

				} // 벽이있으면 끝
				else {
					if (wall[i][j]) {
		//다시 보니 이건 필요없는 듯
					} else {
						dpRow[i][j] = dpRow[i][j - 1] + dpCross[i][j - 1];
						dpCol[i][j] = dpCol[i - 1][j] + dpCross[i - 1][j];
						if (!wall[i][j - 1] && !wall[i - 1][j])
							dpCross[i][j] = dpRow[i - 1][j - 1] + dpCol[i - 1][j - 1] + dpCross[i - 1][j - 1];
						//가로 dp 세로 dp 대각 dp조건에 맞춰서 해당 지억을 가로 파이프로 갈 때, 세로 파이프, 대각파이프일때 각각계산
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
			//가, 세, 대각 다 합친게 답
	}
}
