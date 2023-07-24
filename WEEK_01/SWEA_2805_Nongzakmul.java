package WEEK_01;

import java.util.Scanner;
import java.util.stream.Stream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int SIZE = sc.nextInt();
			int middlePoint = (SIZE-1) / 2;
			int totalSuhwak = 0;
			// 중간지점을 구해서 점점 커지는 구간과 작아지는구간으로 나눠서 계산.
			int[][] nongzak = new int[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
					String numbers = sc.next();
					nongzak[i] = Stream.of(String.valueOf(numbers).split("")).mapToInt(Integer::parseInt).toArray();
			}
			
			for (int i = 0; i <= middlePoint; i++) {
				for (int j = middlePoint - i; j <= middlePoint + i; j++) {
					totalSuhwak += nongzak[i][j];
					
				}
			}
			for (int i = middlePoint + 1; i < SIZE; i++) {
				for (int j = i - middlePoint; j <= + middlePoint *3 - i; j++) {
					totalSuhwak += nongzak[i][j];
				}
			}

			System.out.println("#" + test_case + " " + totalSuhwak);

		}
	}
}