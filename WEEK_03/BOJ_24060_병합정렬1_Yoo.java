package BOJ_24060_병합정렬;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int K = sc.nextInt();

	static int count;

	
	
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
			}
			A[i++] = tmp[t++];
		}
	}
}