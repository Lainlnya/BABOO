package WEEK_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        double[][] percent = new double[4][4];
        //4개 매장으로 주어져서 4,4 배열 만들기
        //  A -> A 매장 갈 확률이 [0][0]에 
        // A -> B 매장 갈 확률이 [0][1]에
        // ... D-> D 매장 갈 확률이 [4][4]에 들어간다.

        double[] result1 = {25, 25, 25, 25};
        double[] result2 = {0.0, 0.0, 0.0, 0.0};
        //초기 랜덤으로 설정되므로 25%씩이므로 result1에 25씩 넣어 선언
        //계산 후 result1에 넣기 전까지 값을 보관해야 하기 때문에 빈 더블 행렬 result2 선언
        for (int i = 0; i < M; i++) {
            int x = change(sc.next());
            int y = change(sc.next());
            double p = sc.nextDouble();
            percent[x][y] = p;
        }

        for (int repeat = 0; repeat < N; repeat++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result2[j] += percent[i][j] * result1[i];
                }
            }
            for (int k = 0; k < 4; k++)
                result1[k] = result2[k];
            Arrays.fill(result2, 0.0);
            // result1을 토대로 갈 확률을 이용해 1회 이동 했을 때 각각에 있을 확률을 계산하여 result2에 대입
            // 확률 계산이 전부 끝난후 result1에 result2값을 넣고 그 후 result2를 초기화 하여 반복하여 계산

        }
        for (int i = 0; i < 4; i++)
            System.out.println(result1[i]);
    }
    // 계산 후 차레대로 값 출력

    public static int change(String A) {
        switch (A) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            default:
                return 0;
        }
    }
    // 문자를 입력받아 그걸 토대로 확률계산하여야 하기 때문에 case를 이용해 a, b, c, d값을 각각 0, 1, 2, 3으로 변환

}