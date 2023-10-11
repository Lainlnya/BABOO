package BOJ_16236_아기상어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static final int INF = 987654321;
	public static int N, srow, scol, size, time, cnt;
	public static int[][] map = new int[20][20];
	public static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	public static boolean[][] visited;

	static class Point {
		// 행, 열, 거리
		int r, c, dist;

		Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	} // Point

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 공간의 크기
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				// 아기 상어의 위치 저장하고, 0으로 바꿔줌
				if (map[i][j] == 9) {
					srow = i;
					scol = j;
					map[i][j] = 0;
				}
			}
		}

		int ans = find(srow, scol);
		System.out.println(ans);

	} // main

	public static int find(int r, int c) {
		// 물고기를 잡아먹을 때까지 걸린 시간
		time = 0;
		// 상어의 크기
		size = 2;
		// 물고기 잡아먹을 때마다 --, 0되면 상어 size + 1
		cnt = 2;
		// 아기 상어가 있는 위치로 초기화, 잡아 먹은 물고기의 위치
		Point min = new Point(r, c, 0);

		// 더 이상 잡아먹을 물고기가 없으면 엄마상어한테 도움 요청
		while (min.dist != INF) {
			// 물고기 한 마리 잡아먹을 때마다 새로 갱신
			visited = new boolean[20][20];
			Queue<Point> queue = new LinkedList<>();
			// 아기 상어가 있던 자리, 물고기 잡아먹은 자리 -> 다시 탐색할 시작점
			visited[min.r][min.c] = true;
			// 큐에 넣고
			queue.add(new Point(min.r, min.c, 0));
			// 엄마 상어까지 거리 INF
			min.dist = INF;

			while (!queue.isEmpty()) {
				Point now = queue.poll();

				// 아기 상어보다 큰 물고기면 먹을 수 없음
				if (map[now.r][now.c] > size)
					continue;
				// 빈칸이 아니고, 아기 상어보다 사이즈가 작을 때
				if (map[now.r][now.c] != 0 && map[now.r][now.c] < size) {
					// min보다 거리가 더 짧으면 갱신해주고
					if (now.dist < min.dist) {
						min = now;
					} else if (now.dist == min.dist) { // 거리가 같으면
						// 더 위쪽에 위치하는 물고기 먼저 잡아먹어야 하고
						if (now.r < min.r) {
							min = now;
						}
						// 같은 행에 위치하면 더 왼쪽에 위치하는 물고기 잡아먹어야 함
						else if (now.r == min.r && now.c < min.c) {
							min = now;
						}
					}
				}

				// 상하좌우 탐색하면서 거리 계산
				for (int idx = 0; idx < 4; idx++) {
					int nr = now.r + dr[idx];
					int nc = now.c + dc[idx];
					// 경계를 벗어나지 않고
					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (!visited[nr][nc]) {
							visited[nr][nc] = true;
							queue.add(new Point(nr, nc, now.dist + 1));
						}
					}
				}
			}

			// 물고기를 잡아먹었으면
			if (min.dist != INF) {
				// 거리만큼 시간 증가 시켜주고
				time += min.dist;
				// 크기가 커질 때까지 남은 물고기 수 -1
				cnt--;
				// cnt가 0이 되면
				if (cnt == 0) {
					// 아기 상어 크기 키우고
					size++;
					// cnt도 size로 갱신
					cnt = size;
				}
				// 잡아먹은 물고기 수 0으로!
				map[min.r][min.c] = 0;
			}
		}
		return time;
	} // find
} // class
