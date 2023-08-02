package WEEK_02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] percent = new double[8][8];
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
				percent[i][j] = sc.nextDouble()/100;
			}
		}
		// 각각의 승률 입력받기

		for (int j = 1; j < 8; j++) {
			for (int i = 0; i < j; i++) {
				percent[j][i] = 1 - percent[i][j];
			}
		}

		// 각각의 승률 뒤집은 것도 계산하여 2차원 배열로 만들기 ( 1번이 0번이길 확률 = 100 - 0번이 1번이길 확률)

		double[] round2P = new double[8];
		double[] round3P = new double[8];
		double[] round4P = new double[8];

		// 라운드별 승률 계산하여 다음 라운드 진출 확률을 계산하기 위해 각각 배열 만들어 활용
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				round2P[i] = (double) (percent[i][i + 1]);
			} else {
				round2P[i] = (double) (percent[i][i - 1]);
			}
		}
		// 2라운드 진출확률계산 쌍쌍이 대결하는 것을 나머지를 활용해서 계산 간략화
		for (int i = 0; i < 5; i = i+4) {
			round3P[i] = round2P[i] * (round2P[i+2] * percent[i][i+2] + round2P[i+3] * percent[i][i+3]);
		}

		for (int i = 1; i < 8; i = i+4) {
			round3P[i] = round2P[i] * (round2P[i+2] * percent[i][i+2] + round2P[i+1] * percent[i][i+1]);
		}
		for (int i = 2; i < 8; i = i+4) {
			round3P[i] = round2P[i] * (round2P[i-2] * percent[i][i-2] + round2P[i-1] * percent[i][i-1]);
		}

		for (int i = 3; i < 8; i = i+4) {
			round3P[i] = round2P[i] * (round2P[i-2] * percent[i][i-2] + round2P[i-3] * percent[i][i-3]);
		}

		//2라운드 진출 확률 및 서로의 승률을 이용해 3라운드 진출 확률 계산, 간략화 실패로 거의 노가다

		for (int i = 0; i < 8; i++) {
			if (i < 4) {
				for (int j = 0; j < 4; j++) {
					round4P[i] += round3P[i] * (round3P[j + 4] * percent[i][j + 4]);
				}
			} else {
				for (int j = 0; j < 4; j++) {
					round4P[i] += round3P[i] * (round3P[j] * percent[i][j]);
				}
				//3라운드 진출 확률 및 서로의 승률을 이용해 4라운드 진출 확률(결승전 우승 확률) 계산

			}
		}
		// 계산한 확률 출력
		for (int i = 0; i < 8; i++)
			System.out.print(round4P[i] + " ");


	}
}