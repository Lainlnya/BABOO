import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, sharkSize, eatCount, totalTime;
    static int[][] ocean;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 0, 1 };
    static int[] dc = { 0, -1, 1, 0 };
    static int[] pShark;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sharkSize = 2;
        eatCount = 2;
        pShark = new int[2];
        ocean = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ocean[i][j] = sc.nextInt();
                if (ocean[i][j] == 9) {
                    pShark[0] = i;
                    pShark[1] = j;
                    ocean[i][j] = 0;
                    // 0 은 i, 1은 j
                }

            }
        } // 입력 끝
        boolean tF = true;
        while (tF) {
            bfs(pShark[0], pShark[1]);
//			System.out.println("[" + pShark[0] + " " + pShark[1] + "time" + totalTime + " sharkSize" + sharkSize
//					+ " eatCount" + eatCount + "]");

        }

    }

    static void bfs(int startI, int startJ) {
        visited = new boolean[N][N];
        int[] targetFish = { Integer.MAX_VALUE, Integer.MAX_VALUE };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startI, startJ, 0 }); // row, colomn, time 기록
        visited[startI][startJ] = true;
        int tmpTime = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {

            int[] pTmp = queue.poll();
            for (int a = 0; a < 4; a++) {
                int newI = pTmp[0] + dr[a];
                int newJ = pTmp[1] + dc[a];
                if (newI >= 0 && newJ >= 0 && newI < N && newJ < N) {
                    if (newI <= targetFish[0]) {

                        if (sharkSize >= ocean[newI][newJ] && !visited[newI][newJ]) {
                            if (pTmp[2] + 1 > tmpTime)
                                continue;
                            if (ocean[newI][newJ] > 0 && sharkSize > ocean[newI][newJ]) {
                                if (targetFish[0] == newI) {
                                    targetFish[1] = Math.min(targetFish[1], newJ);
                                } else {
                                    targetFish[0] = newI;
                                    targetFish[1] = newJ;
                                }
                                tmpTime = pTmp[2] + 1;
                            } // 먹을 수 있는 물고기면 위치 일단 저장 + 먹는데 걸리는 시간 저장
                            if (targetFish[0] == Integer.MAX_VALUE) {
                                visited[newI][newJ] = true;
                                queue.add(new int[] { newI, newJ, pTmp[2] + 1 });

                            } // 타겟 아직 못만나면 bfs
                        } // if 지나갈 수 있는 길 + 안지나감
                    } // 목표 물고기 찾으면 이제 그것보다 낮은 row값만 살펴봄
                } // if 벽면
            } // a for
        } // while
        if (targetFish[0] == Integer.MAX_VALUE) {
            System.out.println(totalTime);
            System.exit(0);
        }
        ocean[targetFish[0]][targetFish[1]] = 0;
        eatCount--;
        if (eatCount == 0) {
            sharkSize++;
            eatCount = sharkSize;
        }
        totalTime += tmpTime;
        pShark[0] = targetFish[0];
        pShark[1] = targetFish[1];
    } // bfs
}
