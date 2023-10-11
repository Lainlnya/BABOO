import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_21610_Cho {

    static int[] dr = {-100, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-100, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] copyDr = {-1, -1, 1, 1};
    static int[] copyDc = {-1, 1, 1, -1};

    static boolean[][] pastCloud;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<int[]> cloudP = new ArrayList<>(); // 구름은 4개, 0은 r좌표, 1은 c좌표
        int[][] baguni = new int[N][N]; //바구니속 물의 양 0, 구름 위치 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                baguni[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 4; i++) {
            cloudP.add(new int[]{N - 2 + i / 2, i % 2});

        }

        //초기 구름 위치

        for (int repeat = 0; repeat < M; repeat++) {
            int d = sc.nextInt();
            int s = sc.nextInt();
            pastCloud = new boolean[N][N];

            for (int[] cP : cloudP) {
                cP[0] = (cP[0] + N * 50 + dr[d] * s) % N;
                cP[1] = (cP[1] + N * 50 + dc[d] * s) % N;
                baguni[cP[0]][cP[1]]++;
                pastCloud[cP[0]][cP[1]] = true;
            } // 구름 이동 및 물 양 증가 및 구름 있었던 위치 기록

            for (int[] cP : cloudP) {
                for (int delta = 0; delta < 4; delta++) {
                    int newI = cP[0] + copyDr[delta];
                    int newJ = cP[1] + copyDc[delta];

                    if (newI >= 0 && newJ >= 0 && newI < N && newJ < N) {
                        if (baguni[newI][newJ] == 0)
                            continue;
                        baguni[cP[0]][cP[1]]++;


                    }


                }

            } // 물복사 버그
            cloudP.clear(); //구름 없애기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (baguni[i][j] >= 2 && !pastCloud[i][j]) {
                        baguni[i][j] -= 2;
                        cloudP.add(new int[]{i, j});
                    }

                }
            } // 새 구름 생성


        }


        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sum += baguni[i][j];
        }
        System.out.println(sum);
        //답
    }
}
