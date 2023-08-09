package WEEK_03;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int K = sc.nextInt();

	static int count;

	// 재귀 함수 내에서 쉽게 사용하기 위한 변수들 static 선언;
	public static void main(String[] args) {

		int[] A = new int[N];
		count = 0;
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();

		merge_sort(A, 0, N - 1);
		System.out.println(-1);

	}

	public static void merge_sort(int[] A, int p, int r) {

		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}

	}

	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 1;
		int[] tmp = new int[r - p + 2];

		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {

				tmp[t++] = A[i++];

			} else {

				tmp[t++] = A[j++];
			}
		}
		while (i <= q) {

			tmp[t++] = A[i++];
		}
		while (j <= r) {

			tmp[t++] = A[j++];
		}

		i = p;
		t = 1;
		while (i <= r) {
			if (++count == K) {
				System.out.println(tmp[t]);
				System.exit(0);
			} //최종비교 및 값 할당 시점에 저장 횟수와 K가 같은지 파악 후 같으면 그 때의 할당값을 반환하고 시스템을 종료시킴.
			A[i++] = tmp[t++];

		}

	}

}
