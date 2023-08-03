package WEEK_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1404_Tournament_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[][] tm = new double[8][8]; // 토너먼트 전체 확률 배열
        double[] result = new double[8]; // 2라운드까지의 결과값 배열
        double[] answer = new double[8]; // 마지막 라운드 결과값 배열

        // 값 받아서 토너먼트 전체 승률 저장하기
        for (int i = 0; i < tm.length; i++) {
            for (int j = i + 1; j < tm.length; j++) {
                tm[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
            }
        }

        // 기존 토너먼트 배열에 반대의 확률은 없으므로 반대의 확률을 저장하는 반복문
        for (int i = 1; i < tm.length; i++) {
            for (int j = 0; j < i ; j++) {
                tm[i][j] = 1 - tm[j][i];
            }
        }

        // 1라운드
        // 1라운드는 2 * i번 참가자와 2 * (i + 1) 번 참가자의 경기이기에 [0, 1] [2, 3] [4, 5] [6, 7] 끼리의 확률을 result에 저장
        for (int i = 0; i < tm.length; i++) {
            for (int j = i; j <= 3; j++) {
                result[j * 2] = tm[j * 2][j * 2 + 1];
                result[j * 2 + 1] = tm[j * 2 + 1][j * 2];
            }
        }

        // 2라운드
        // 2라운드는 반으로 나눠서 계산
        // [0, 1] 에서 0이 이기고, [2, 3]에서 2나 3이 이길 확률을 구하는 방식으로 전체 2라운드의 확률을 계산
        // 2라운드 0의 확률 *= (0과 2 중 0이 이길 확률 * 2와 3중 2가 이길 확률 + 0과 3중 0이 이길 확률 * 2와 3중 3이 이길 확률)
        int k = 1;
        for (int i = 0; i < tm.length; i++) {
            if (i > 3) k = 5;
            if (i % (tm.length / 2) <= 1) {
                result[i] *= (tm[i][k + 1] * tm[k + 1][k + 2] + tm[i][k + 2] * tm[k + 2][k + 1]);
            } else {
                result[i] *= (tm[i][k - 1] * tm[k - 1][k] + tm[i][k] * tm[k][k - 1]);
            }
        }

        // 3라운드
        // 0이 최종 결승에 올라올 확률 = 0과 4중 0이 이길 확률 * 4가 최종 결승에 올라올 확률 ~ 0과 7중 0이 이길 확률 * 7이 이길 확률
        // 위와 같은 방식으로 전체 확률 계산
        for (int i = 0; i < tm.length; i++) {
            if (i < tm.length / 2) {
                answer[i] = result[i] * (tm[i][4] * result[4] + tm[i][5] * result[5] + tm[i][6] * result[6] + tm[i][7] * result[7]);
            } else {
                answer[i] = result[i] * (tm[i][0] * result[0] + tm[i][1] * result[1] + tm[i][2] * result[2] + tm[i][3] * result[3]);
            }
        }

        // 결과값 프린트
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

