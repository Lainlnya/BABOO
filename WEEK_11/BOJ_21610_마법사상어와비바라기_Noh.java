package BOJ_21610_마법사상어와비바라기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[][] map, command;
	public static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	public static ArrayList<int[]> clouds;
	public static boolean[][] visited, newVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 격자 크기
		N = sc.nextInt();
		// 명령의 개수
		M = sc.nextInt();

		map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		command = new int[M][2];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 2; j++) {
				command[i][j] = sc.nextInt();
			}
		}

		// 구름이 있는 칸 정보 저장
		clouds = new ArrayList<>();
		// M번째 명령 수행 전 구름이 있는 곳 저장
		visited = new boolean[N + 1][N + 1];
		// 새로 생기는 구름 정보 저장해서 visited에 갱신
		newVisited = new boolean[N + 1][N + 1];

		// 초기 구름 설정
		clouds.add(new int[] { N, 1 });
		clouds.add(new int[] { N, 2 });
		clouds.add(new int[] { N - 1, 1 });
		clouds.add(new int[] { N - 1, 2 });

		// M번의 명령 수행

		for (int i = 0; i < M; i++) {
			int d = command[i][0];
			int s = command[i][1];

			// 1. 명령만큼 구름 이동시킴
			move(clouds, d, s);
			// 2. 구름이 있는 칸의 바구니에 저장된 물의 양 1 증가
			rain(clouds);
			// 4. 물복사버그 마법 시전
			copyBug(clouds);
			// 5. 새로 구름이 생겨남!
			make();

			// 명령마다 새로 갱신!
			visited = new boolean[N + 1][N + 1];
			newVisited = new boolean[N + 1][N + 1];
		}

		// 모든 칸의 합 계산해서 출력
		int ans = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);

	} // main

	public static void move(ArrayList<int[]> clouds, int d, int s) {
		for (int[] c : clouds) {
			for (int i = 0; i < s; i++) {
				c[0] += dr[d];
				// 서로 연결되어 있으니까 경계 벗어나는거 처리
				if (c[0] == 0)
					c[0] = N;
				if (c[0] == N + 1)
					c[0] = 1;

				c[1] += dc[d];
				// 서로 연결되어 있으니까 경계 벗어나는거 처리
				if (c[1] == 0)
					c[1] = N;
				if (c[1] == N + 1)
					c[1] = 1;
			}

			// 이동한 구름 정보 저장 -> 이 곳은 새로 구름이 생기지 않음!
			visited[c[0]][c[1]] = true;
		}

	} // move

	public static void rain(ArrayList<int[]> clouds) {
		for (int[] c : clouds) {
			int nr = c[0];
			int nc = c[1];

			// 구름이 있는 칸의 바구니에 저장된 물의 양 1증가
			map[nr][nc]++;
		}
	} // rain

	public static void copyBug(ArrayList<int[]> clouds) {
		int[] ar = { -1, -1, 1, 1 };
		int[] ac = { -1, 1, -1, 1 };

		for (int[] c : clouds) {
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = c[0] + ar[i];
				int nc = c[1] + ac[i];

				// 경계를 넘어가지 않으면서
				if (nr >= 1 && nr <= N & nc >= 1 && nc <= N) {
					// 물이 있는 바구니
					if (map[nr][nc] > 0)
						cnt++;
				}
			}
			// 거리가 1인 칸에 있는 물이 있는 바구니 수만큼 물의 양 증가
			map[c[0]][c[1]] += cnt;
		}

		clouds.clear();
	} // copyBug

	public static void make() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				// 3에서 구름이 사라진 칸이 아니고 바구니에 저장된 물의 양이 2이상 이면
				if (!visited[i][j] && map[i][j] >= 2) {
					// 구름이 생기고
					clouds.add(new int[] { i, j });
					// 물의 양이 2만큼 줄어듬
					map[i][j] -= 2;
				}
			}
		}
	} // make

} // class