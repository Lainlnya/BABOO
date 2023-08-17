import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testCase = 0; testCase < T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				B[i] = sc.nextInt();

			Arrays.sort(A);
			Arrays.sort(B); 
			
//			A = countSort(A); 
//			B = countSort(B);
			// 받아온 후 정렬 왠지 모르게 직접 구현한 countSort는 index에 음수값이 뜬다는 오류가 떠 그냥 sort기능사용
			
			int idx = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				while (idx < M && A[i] > B[idx])
					idx++; // 정렬되어있기에 A가 B의 특정지점보다 작아질 때까지 B의 idx를 증가
				sum += idx; // B가 A보다 크거나 같아지거나 B idx끝까지 갔을 때 전체 합에 더해줌
			}

			System.out.println(sum);
		}
	}

	static int[] countSort(int[] arr) {

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int[] cArr = new int[max + 1];
		for (int i = 0; i < arr.length; i++)
			cArr[arr[i]]++;

		for (int i = 1; i <= max; i++)
			cArr[i] += cArr[i - 1];

		int[] sortArr = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			sortArr[--cArr[arr[i]]] = arr[i];
		}

		return sortArr;
	}
}
