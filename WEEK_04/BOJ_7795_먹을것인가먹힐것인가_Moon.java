package BOJ_7795_먹을것인가먹힐것인가;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 7분
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			int[] sizeA = new int[A];
			int[] sizeB = new int[B];
			for (int i = 0; i < A; i++) {
				sizeA[i] = sc.nextInt();
			}
			for (int i = 0; i < B; i++) {
				sizeB[i] = sc.nextInt();
			}
			
			Arrays.sort(sizeA);
			Arrays.sort(sizeB);
			
			// A가 B보다 큰 쌍의 개수를 출력한다.
			int ans = 0;
			
			AF: for (int i = 0; i < A; i++) {
				for (int j = 0; j < B; j++) {
					if (sizeA[i] > sizeB[j]) {
						ans++;
					} else {
						continue AF;
					}	
				}
			}

			System.out.println(ans);
			
		}
		
		sc.close();
	}
}