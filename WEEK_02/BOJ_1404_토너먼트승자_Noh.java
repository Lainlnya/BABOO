package BOJ;

import java.util.Scanner;

public class BOJ_S3_1404_토너먼트승자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] prob = new double[8][8];
		double[] win1 = new double[8];
		double[] win2 = new double[8];
		double[] win3 = new double[8];

		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
				prob[i][j] = sc.nextInt() * 0.01;
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
				prob[j][i] = 1 - prob[i][j];
			}
		}

		// 1라운드
		// 2×i번 참가자와 2×i+1번 참가자의 경기
		for (int i = 0; i < 4; i++) {
			win1[2*i] = prob[2*i][2*i+1];
			win1[2*i+1] = prob[2*i+1][2*i];
		}

		// 2라운드
		for (int i = 0; i < 2; i++) {
			win2[4*i] = win1[4*i]*win1[4*i+2]*prob[4*i][4*i+2]+win1[4*i]*win1[4*i+3]*prob[4*i][4*i+3];
			win2[4*i+1] = win1[4*i+1]*win1[4*i+2]*prob[4*i+1][4*i+2]+win1[4*i+1]*win1[4*i+3]*prob[4*i+1][4*i+3];
			win2[4*i+2] = win1[4*i+2]*win1[4*i]*prob[4*i+2][4*i]+win1[4*i+2]*win1[4*i+1]*prob[4*i+2][4*i+1];
			win2[4*i+3] = win1[4*i+3]*win1[4*i]*prob[4*i+3][4*i]+win1[4*i+3]*win1[4*i+1]*prob[4*i+3][4*i+1];
		}

		// 3라운드
		win3[0] = win2[0] * (win2[4] * prob[0][4] + win2[5] * prob[0][5] + win2[6] * prob[0][6] + win2[7] * prob[0][7]);
		win3[1] = win2[1] * (win2[4] * prob[1][4] + win2[5] * prob[1][5] + win2[6] * prob[1][6] + win2[7] * prob[1][7]);
		win3[2] = win2[2] * (win2[4] * prob[2][4] + win2[5] * prob[2][5] + win2[6] * prob[2][6] + win2[7] * prob[2][7]);
		win3[3] = win2[3] * (win2[4] * prob[3][4] + win2[5] * prob[3][5] + win2[6] * prob[3][6] + win2[7] * prob[3][7]);
		win3[4] = win2[4] * (win2[0] * prob[4][0] + win2[1] * prob[4][1] + win2[2] * prob[4][2] + win2[3] * prob[4][3]);
		win3[5] = win2[5] * (win2[0] * prob[5][0] + win2[1] * prob[5][1] + win2[2] * prob[5][2] + win2[3] * prob[5][3]);
		win3[6] = win2[6] * (win2[0] * prob[6][0] + win2[1] * prob[6][1] + win2[2] * prob[6][2] + win2[3] * prob[6][3]);
		win3[7] = win2[7] * (win2[0] * prob[7][0] + win2[1] * prob[7][1] + win2[2] * prob[7][2] + win2[3] * prob[7][3]);


		for (int i = 0; i < 8; i++) {
			System.out.print(win3[i] + " ");
		}

	}
}
