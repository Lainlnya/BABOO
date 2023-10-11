package BOJ_16236_아기상어;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 상어의 현재 크기, 경험치, 먹는데 걸린 시간, 위치를 기록한다
	static class Shark {
		int size, exp, time, r, c;

		public Shark(int size, int exp, int time, int r, int c) {
			this.size = size;
			this.exp = exp;
			this.time = time;
			this.r = r;
			this.c = c;
		}
	}

	// BFS를 하는 데 필요한 위치, 상어로부터의 거리 기록
	static class Space {
		int r, c, d;

		public Space(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int N, eatR, eatC, eatD;
	static int[][] sea;
	static Queue<Space> queue = new LinkedList<>();
	static Shark shark;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// sea : 공간의 상태는 나타내는 2차원 배열
		// 0 : 빈칸 1~6 : 칸에 있는 물고기의 크기
		// 9 : 아기 상어
		sea = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sea[i][j] = sc.nextInt();
				if (sea[i][j] == 9) {
					shark = new Shark(2, 0, 0, i, j);
					sea[i][j] = 0;
				}
			}
		}

		visited = new boolean[N][N]; // BFS 돌면서 방문여부 기록
		// 먹이 먹을 장소 선택하기 위한 int, 거리
		eatR = 10000; // 행이나 열 값이 작을수록 먼저 먹을것이므로 적당히 큰 값으로 초기화
		eatC = 10000;
		eatD = -1; // 이것보다 먼 지점이 queue에서 나오면 break 할 예정
		BFS();
		
		// 먹이를 다 먹고 아기상어가 먹이를 먹는 데 걸린 시간을 출력
		System.out.println(shark.time);

		sc.close();
	}

	public static void BFS() {
		// 초기화
		visited = new boolean[N][N];
		queue.clear();
		queue.offer(new Space(shark.r, shark.c, 0));
		visited[shark.r][shark.c] = true;
		
		eatR = 10000;
		eatC = 10000;
		eatD = -1;
		
		// BFS
		while (!queue.isEmpty()) {
			// 더 먼 칸이 queue에서 나올 때에는 break하고
			// BFS method 마지막부분에서 eatD가 -1이 아닌것이 확인되면 먹이를 먹으러 간다
			if (queue.peek().d == eatD)
				break;
				
			Space space = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = space.r + dr[i];
				int nc = space.c + dc[i];
				
				if (Range(nr, nc) && !visited[nr][nc]) {
					// 비어있거나 아기상어와 같은 크기의 먹이가 있는 칸은 지나간다
					if (sea[nr][nc] == 0 || sea[nr][nc] == shark.size) {
						queue.offer(new Space(nr, nc, space.d + 1));
						visited[nr][nc] = true;
					// 아기상어보다 작은 크기의 먹이가 있는 칸은 먹이 후보가 된다
					} else if (sea[nr][nc] < shark.size) {
						// 그 중에서도 행과 열 값이 작은 칸의 먹이부터 먹는다
						if (eatR > nr) {
							eatR = nr;
							eatC = nc;
						} else if (eatR == nr) {
							if (eatC > nc) {
								eatC = nc;
							}
						}
						visited[nr][nc] = true;
						eatD = space.d + 1;
					}
				}
			}
		}
		
		// 먹을 수 있는 먹이가 있으면 먹으러 가자
		if (eatD != -1) eat();
	}
	
	public static void eat() {
		// 먹으면 빈칸으로 만들어준다
		sea[eatR][eatC] = 0;
		// 상어가 먹이를 먹고 경험치를 쌓았을 때
		shark.exp++;
		// 경험치 통이 꽉 찼으면 레벨업도 해준다
		levelUp();
		// 상어 상태 갱신
		shark = new Shark(shark.size, shark.exp, shark.time + eatD, eatR, eatC);
		// 다음 먹이 찾으러 가자
		BFS();
	}

	// 칸을 벗어나는지 확인해주는 method
	public static boolean Range(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

	// 상어 경험치통 꽉찼으면 레벨업해주는 method
	public static void levelUp() {
		if (shark.size == shark.exp) {
			shark.size++;
			shark.exp = 0;
		}
		return;
	}
}