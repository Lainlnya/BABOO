package BOJ_23290_마법사상어와복제;

import java.util.Scanner;

public class Main {

	static class Shark {
		int r, c;

		public Shark(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Dir {
		int dr, dc;

		public Dir(int dr, int dc) {
			this.dr = dr;
			this.dc = dc;
		}
	}

	// 상 좌 하 우는 1, 3, 5, 7번째 index
	// 0번째 index는 움직이지 않음
	static Dir[] dir = { new Dir(0, 0), new Dir(0, -1), new Dir(-1, -1), new Dir(-1, 0), new Dir(-1, 1), new Dir(0, 1),
			new Dir(1, 1), new Dir(1, 0), new Dir(1, -1) };
	
	static Dir[] sharkdir = { new Dir(0, 0), new Dir(-1, 0), new Dir(0, -1), new Dir(1, 0), new Dir(0, 1) };

	static Shark shark;
	static int[][][] sea = new int[5][5][9];
	static int[][] sharkMove = new int[65][3];
	static int[][] smell = new int[5][5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // 물고기의 수
		int S = sc.nextInt(); // 상어가 마법을 연습한 횟수

		// 물고기 받아오기
		// 4*4 행렬을 8개 만들어서 방향별로 따로 저장해준다.
		for (int i = 0; i < M; i++)
			sea[sc.nextInt()][sc.nextInt()][sc.nextInt()]++;

		// 상어 위치 받아오기
		shark = new Shark(sc.nextInt(), sc.nextInt());

		// 상어 이동방향 만들어주기
		int idx = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					sharkMove[idx][0] = i;
					sharkMove[idx][1] = j;
					sharkMove[idx][2] = k;
					idx++;
				}
			}
		}

		// 복제마법 쓰기
		for (int i = 0; i < S; i++) {
			Magic();
		}

		// 물고기 몇마리 남아있는지 확인하기
		int cnt = 0;
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				for (int d = 1; d <= 8; d++) {
					cnt += sea[r][c][d];
				}
			}
		}

		// 출력
		System.out.println(cnt);

		sc.close();
	}

	public static void Magic() {

		// 1. 상어가 모든 물고기에게 복제 마법을 시전한다.
		int[][][] magic = sea;

		// 2. 모든 물고기가 한 칸 이동한다.
		int[][][] move = new int[5][5][9];
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				for (int d = 1; d <= 8; d++) {
					if (sea[r][c][d] != 0) {
						// 물고기가 있으면 이동한다.
						int nd = d;
						int nr = r + dir[nd].dr;
						int nc = c + dir[nd].dc;
						int temp = 0; // 반시계 방향으로 45도 회전한 횟수
						while (!fishRange(nr, nc) && temp < 8) {
							// 만약 새로 이동할 위치가 유효하지 않으면 계속 돌려준다.
							// 한 바퀴 돌아도 유효한 위치가 없을 때에는 반복문을 탈출한다.
							nd = FishTurn(nd);
							nr = r + dir[nd].dr;
							nc = c + dir[nd].dc;
							temp++;
						}
						if (temp != 8) {
							// 유효한 방향을 찾은 경우에는 새로운 위치로 이동한다.
							move[nr][nc][nd] += sea[r][c][d];
						} else {
							// 유효한 방향을 찾지 못한 경우(temp == 8)에는 기존 위치에 다시 저장한다.
							move[r][c][d] += sea[r][c][d];
						}
					}
				}
			}
		}

		// 3. 상어가 연속해서 3칸 이동한다.
		int maxEat = 0;
		int maxIdx = -1;
		// 물고기를 최대로 먹을 수 있는 이동방향을 찾지 못했을 경우를 대비하여
		// 이동할 수 있는 방향 중 사전순으로 가장 앞선 방향을 기록한다.
		int ifNoFish = -1;
		for (int i = 1; i <= 64; i++) {
			// 초기화
			int eat = 0;
			int nr = shark.r;
			int nc = shark.c;
			// 이미 방문했던 곳에 있는 물고기는 두 번 먹지 못하므로 방문 여부를 기록한다.
			boolean[][] visited = new boolean[5][5];
			// 계산
			for (int j = 0; j < 3; j++) {
				nr = nr + sharkdir[sharkMove[i][j]].dr;
				nc = nc + sharkdir[sharkMove[i][j]].dc;
				if (!sharkRange(nr, nc)) {
					// 유효하지 못한 이동 경로의 경우에는 그동안 먹은 물고기를 다 뱉고 반복문을 탈출한다.
					eat = 0;
					break;
				}
				if (!visited[nr][nc]) {
					// 만약 방문했던 칸을 다시 방문한 경우에는 앞서 말한대로 물고기를 두 번 먹지 않는다.
					for (int k = 1; k <= 8; k++) {
						eat += move[nr][nc][k];
					}
					visited[nr][nc] = true;						
				}
				// 근처에 물고기가 없어 어느 방향으로도 물고기를 먹지 못하는 경우에는
				// 유효한 방향 중 사전 순으로 가장 앞선 방향으로라도 움직인다.
				if (j == 2 && ifNoFish == -1) {
					ifNoFish = i;
				}
			}
			if (eat > maxEat) {
				// 더 많은 먹이를 먹는 경로를 찾으면 갱신한다.
				maxEat = eat;
				maxIdx = i;
			}
		}
		if (maxIdx == -1) {
			// 만약 먹이를 먹을 수 있는 방법이 없을 때에는 그냥 사전 순으로 가장 앞선 방향으로 움직인다.
			for (int i = 0; i < 3; i++) {
				shark = new Shark(shark.r + sharkdir[sharkMove[ifNoFish][i]].dr, shark.c + sharkdir[sharkMove[ifNoFish][i]].dc);
			}
		} else {
			// 최대로 먹이를 많이 먹을 수 있는 경로로 이동을 하며
			for (int i = 0; i < 3; i++) {
				// 상어가 한 칸 이동
				shark = new Shark(shark.r + sharkdir[sharkMove[maxIdx][i]].dr, shark.c + sharkdir[sharkMove[maxIdx][i]].dc);
				// 해당 칸에 물고기가 있는지 확인한다. (모든 방향에 대해 탐색)
				// 물고기를 먹어야 냄새가 생기므로 물고기가 있는지를 꼭 확인해줘야 한다.
				boolean fish = false;
				for (int j = 1; j <= 8; j++) {
					if (move[shark.r][shark.c][j] != 0) {
						// 물고기를 찾으면 반복문을 탈출하고 물고기를 먹으러 간다.
						fish = true;
						break;
					}
				}
				// 물고기를 먹는다.
				if (fish) {
					for (int j = 1; j <= 8; j++) {
						// 해당 칸에서 모든 방향의 물고기를 다 먹어준다.
						move[shark.r][shark.c][j] = 0;
					}
					// 물고기 냄새를 남긴다.
					// 4에서 두 번 전 연습에서 생긴 물고기의 냄새를 지워야 하는데
					// 현재 단계에서 만든 냄새를 다음 단계에서 바로 한 번 깎아주기 때문에
					// 초기값을 3으로 설정한다.
					smell[shark.r][shark.c] = 3; 
				}
			}
		}

		// 4. 두 번 전 연습에서 생긴 물고기의 냄새가 격자에서 사라진다.
		// 0이 아닌 칸에 대해 -1씩 해주면 두 번 전 연습에서 생긴 물고기의 냄새는 이 때 0으로 돌아온다.
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				if (smell[r][c] > 0) {
					smell[r][c]--;
				}
			}
		}

		// 5. 1에서 사용한 복제 마법이 완료된다.
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				for (int d = 1; d <= 8; d++) {
					sea[r][c][d] = move[r][c][d] + magic[r][c][d];
				}
			}
		}
		
	}

	// 물고기의 이동 가능 여부를 확인해준다.
	// 1.범위를 벗어나지 않으며 2.상어의 위치와 겹치지 않으며 3.물고기 냄새가 남아있지 않은 곳
	public static boolean fishRange(int r, int c) {
		if (r > 0 && r <= 4 && c > 0 && c <= 4) {
			if (r != shark.r || c != shark.c) {
				if (smell[r][c] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	// 상어의 이동 가능 여부를 확인해준다.
	// 범위를 벗어나지만 않으면 된다.
	public static boolean sharkRange(int r, int c) {
		if (r > 0 && r <= 4 && c > 0 && c <= 4) {
			return true;
		}
		return false;
	}

	// 물고기가 이동 방향을 정할 때 반시계 방향으로 45도씩 회전해본다.
	public static int FishTurn(int d) {
		d--;
		if (d == 0)
			return 8;
		return d;
	}
}