package WEEK_01;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		Loop1 :
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] sdoku = new int[9][9];
			int[] Array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = sc.nextInt();
				}
			}

			int[][] rowSdoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					rowSdoku[i][j] = sdoku[i][j];
				}
			}

			for (int i = 0 ; i < 9; i++) {
				Arrays.sort(rowSdoku[i]);
				if (!(Arrays.equals(rowSdoku[i], Array))) {
					System.out.println("#" + test_case + " " + 0);
					continue Loop1;
				}
				
			}
			
			
			
			
			int[][] colSdoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					colSdoku[i][j] = sdoku[j][i];
				}
			}
			
			for (int i = 0 ; i < 9; i++) {
				Arrays.sort(colSdoku[i]);
				if (!(Arrays.equals(colSdoku[i], Array))) {
					System.out.println("#" + test_case + " " + 0);
					continue Loop1;
				}
				
			}
			
			int[][] squareSdoku = new int[9][9];
			
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					squareSdoku[i][j] = sdoku[(i*3)%9 + j/3][i/3*3 + j%3];
				}
			}

			for (int i = 0 ; i < 9; i++) {
				Arrays.sort(squareSdoku[i]);
				if (!(Arrays.equals(squareSdoku[i], Array))) {
					System.out.println("#" + test_case + " " + 0);
					continue Loop1;
				}
				
			}
			
			System.out.println("#" + test_case + " " + 1);
			
			//90분
			// 가로 세로 정사각방식 전부 일렬로 세운 후 작은거에서 큰거 순으로 정렬한뒤 [1, 2, 3, 4, 5, 6, 7, 8, 9] 배열과 같은지 비교
			// 정사각 스도쿠를논리적으로 일렬로 세우는 것에 애먹음
			//Array.equals 사용을 잘못해서 30분은 날림
		}
	}
}