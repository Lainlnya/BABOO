package WEEK_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int[] numbers = new int[M];
		int N = 0;
		for (int i = 0 ; i < M ; i++ ) {
			numbers[i] = sc.nextInt();
			N += numbers[i];
		}

		int K = sc.nextInt();
		//값 입력받기
		double[] percent = new double[M];
		//개수가 m개 이므로 각 색깔별 같은것을 뽑을 확률계산;
		Arrays.fill(percent, 1.0);
		//1개만 뽑을 경우 확률이 100% = 1.0 이므로 전부 1을 채워넣음
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j < K ; j++)
				percent[i] *= (double)(numbers[i]-j) / (double)(N-j);
		}
		//재귀로 한개뽑을 때마다 전체 개수 1개 줄이고, 뽑을 수 있는 개수도 1개 줄여서 확률 계산 후 곱
		double sum = 0;
		for (int i = 0 ; i < M ; i++) {
			sum += percent[i];
		}

		//색깔별로 구해진 확률을 더해서 출력

		System.out.println(sum);
	}

}