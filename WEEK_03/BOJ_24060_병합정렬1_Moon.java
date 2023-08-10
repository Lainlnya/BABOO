package BOJ_24060_병합정렬1;

import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int[] tmp;
	public static int K;
	public static int cnt;
	
	public static void main(String[] args) {
		/*
		 * 24060 알고리즘 수업 - 병합 정렬 1
		 * 11시30분~12시30분
		 * 13시15분~14시20분
		 * 
		 * 저장될 때마다 cnt++ 해주고, cnt가 K와 같아지면 출력 후 코드 종료.
		 * 만약 merge sort가 끝까지 진행되는 내내 cnt값이 K보다 같아지지 않으면(계속 작으면)
		 * 재귀가 종료된 후 -1을 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		K = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		tmp = new int[arr.length];
		cnt = 0;
		
		mergeSort(arr, 0, arr.length-1); // 재귀
		
		if (cnt < K) {
			System.out.println(-1);
		}
		
		sc.close();
	}
	
	
	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p+r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
			
		}
	}
	
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;

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
		t = 0;
		while (i <= r) {
			cnt++;
			if (cnt == K) {
				System.out.println(tmp[t]);
				System.exit(0);
			}
			A[i++] = tmp[t++];
		}
	}

}