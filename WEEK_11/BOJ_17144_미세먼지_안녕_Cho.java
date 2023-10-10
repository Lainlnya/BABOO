import java.util.Scanner;

public class Main {
    static int R, C;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, -0, -1 };
    static int[][] dust;
    static int airCleanStart;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        int T = sc.nextInt();
        dust = new int[R][C];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                dust[i][j] = sc.nextInt();
        // 입력 끝
        for (int i = 0; i < R; i++) {
            if (dust[i][0] == -1) {
                airCleanStart = i;
                break;
            }
        } // 공기청정기 위치 확인

        for (int repeat = 0; repeat < T; repeat++) {
            int[][] tmpDust = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (dust[i][j] == -1) {
                        tmpDust[i][j] = -1;
                        continue;
                    }
                    int pCount =0 ; // 주변에 확산 가능 지역 숫자

                    for (int a = 0 ; a < 4; a++) {
                        int newI = i+ dr[a];
                        int newJ = j+ dc[a];
                        if ( newI >=0 && newJ >=0 && newI <R && newJ <C) {
                            if (dust[newI][newJ] != -1) {
                                pCount++;
                                tmpDust[i][j] +=dust[newI][newJ]/5;
                            }

                        }


                    } //a for
                    tmpDust[i][j] += dust[i][j] - dust[i][j]/5 * pCount;



                } // j for
            } // i for

            for (int i = 0 ; i <R; i++) {
                dust[i] = tmpDust[i].clone();
            }
            airCleaning();
        } // repeat for

        int sum = 2; // 공기청정기 때문에 -2되므로 2에서 시작
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//				System.out.print(dust[i][j] + " ");
                sum += dust[i][j];
            }
//			System.out.println();
        } // 먼지 합
        System.out.println(sum);

    }

    public static void airCleaning() {
        for (int i = airCleanStart -1 ; i >0 ;i--) {
            dust[i][0] = dust[i-1][0];
        }
        for (int j = 0 ; j < C-1; j++) {
            dust[0][j] = dust[0][j+1];
        }
        for (int i = 0 ; i < airCleanStart ; i++) {
            dust[i][C-1] = dust[i+1][C-1];
        }
        for (int j = C-1 ; j > 1 ; j--) {
            dust[airCleanStart][j] = dust[airCleanStart][j-1];
        } // 공기청정기 윗부분

        for (int i = airCleanStart + 2 ; i < R-1; i++) {
            dust[i][0] = dust[i+1][0];
        }

        for (int j = 0 ; j < C-1; j++) {
            dust[R-1][j] = dust[R-1][j+1];
        }
        for (int i = R-1 ; i >= airCleanStart + 1 ; i--) {
            dust[i][C-1] = dust[i-1][C-1];
        }
        for (int j = C-1 ; j > 1 ; j--) {
            dust[airCleanStart+1][j] = dust[airCleanStart+1][j-1];
        } // 공기청정기 아랫부분

        dust[airCleanStart][1] = 0;
        dust[airCleanStart+1][1] = 0;

    } //공기 청정기 돌리기

}
