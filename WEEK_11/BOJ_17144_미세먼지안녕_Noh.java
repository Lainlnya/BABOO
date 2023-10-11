package BOJ_17144_미세먼지안녕;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int R, C, T;
	public static int[][] grid, dust, airClean;
	public static Queue<int[]> queue;

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 격자판 가로크기
		R = sc.nextInt();
		// 격자판 세로크기
		C = sc.nextInt();
		// T초 후 구사과의 방에 남아 있는 미세먼지 양 구하기
		T = sc.nextInt();

		// 미세먼지 정보
		grid = new int[R][C];
		// 공기 청정기 위치 저장
		airClean = new int[2][2];

		int n = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				grid[i][j] = sc.nextInt();
				// 공기 청정기 위치 저장
				if (grid[i][j] == -1) {
					airClean[n][0] = i;
					airClean[n++][1] = j;
				}
			}
		}

		// T초 동안 공기청정기 작동
		queue = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			// 확산되는 상태 임시 저장
			dust = new int[R][C];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (grid[r][c] > 0)
						// 동시 확산을 위해서 BFS 이용
						queue.add(new int[] { r, c, grid[r][c] });
				}
			}
			// 1. 미세먼지 확산
			diffusion(queue);

			// 2. 공기청정기 작동
			cleanUp(airClean[0][0], airClean[0][1]);
			cleanDown(airClean[1][0], airClean[1][1]);
		}

		// 공기청정기 -1 고려
		int ans = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += grid[i][j];
			}
		}
		System.out.println(ans);

	} // main

	public static void diffusion(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int cnt = 0;
			int[] now = queue.poll();

			for (int idx = 0; idx < 4; idx++) {
				int nr = now[0] + dr[idx];
				int nc = now[1] + dc[idx];

				// 경계를 벗어나지 않고, 공기청정기 있는 곳이 아니면
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] != -1) {
					// 미세먼지 확산 시키고
					dust[nr][nc] += (now[2] / 5);
					cnt++;
				}
			}
			// 확산 후 남은 미세먼지 양 계산
			grid[now[0]][now[1]] = now[2] - (now[2] / 5) * cnt;
		}

		// 미세먼지 확산 된 상태 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				grid[i][j] += dust[i][j];
			}
		}
	} // diffusion

	public static void cleanUp(int si, int sj) {
		Queue<Integer> queue = new LinkedList<>();

		// 우
		for (int j = sj + 1; j < C - 1; j++)
			queue.add(grid[si][j]);
		// 상
		for (int i = si; i > 0; i--)
			queue.add(grid[i][C - 1]);
		// 좌
		for (int j = C - 1; j > 0; j--)
			queue.add(grid[0][j]);
		// 하
		for (int i = 0; i < si; i++)
			queue.add(grid[i][0]);

		// 공기 청정기에 들어간 미세먼지는 정화됨
		grid[si][sj + 1] = 0;
		// 우
		for (int j = sj + 2; j < C - 1; j++)
			grid[si][j] = queue.poll();
		// 상
		for (int i = si; i > 0; i--)
			grid[i][C - 1] = queue.poll();
		// 좌
		for (int j = C - 1; j > 0; j--)
			grid[0][j] = queue.poll();
		// 하
		for (int i = 0; i < si; i++)
			grid[i][0] = queue.poll();
	} // cleanUp

	public static void cleanDown(int si, int sj) {
		Queue<Integer> queue = new LinkedList<>();

		// 우
		for (int j = sj + 1; j < C - 1; j++)
			queue.add(grid[si][j]);
		// 하
		for (int i = si; i < R - 1; i++)
			queue.add(grid[i][C - 1]);
		// 좌
		for (int j = C - 1; j > 0; j--)
			queue.add(grid[R - 1][j]);
		// 상
		for (int i = R - 1; i > si; i--)
			queue.add(grid[i][0]);

		// 공기 청정기에 들어간 미세먼지는 정화됨
		grid[si][sj + 1] = 0;
		// 우
		for (int j = sj + 2; j < C - 1; j++)
			grid[si][j] = queue.poll();
		// 하
		for (int i = si; i < R - 1; i++)
			grid[i][C - 1] = queue.poll();
		// 좌
		for (int j = C - 1; j > 0; j--)
			grid[R - 1][j] = queue.poll();
		// 상
		for (int i = R - 1; i > si; i--)
			grid[i][0] = queue.poll();
	} // cleanDown

} // class
