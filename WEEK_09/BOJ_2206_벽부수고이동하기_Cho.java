import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int[][] map;
	static boolean[][] visited;
	static boolean[][] cVisited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		cVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 1)
					cVisited[i][j] = true; //1이면 길이 막혀있으므로 이미 방문했다고 가정하여 true 바꿔놈
			} // j for
		} // i for 입력 끝

		bfs();
		if (N == 1 && M == 1)
			System.out.println(1); //97% 쯤에 에러 발생해서 1x1 칸 이면 성립안해서 예외처리
		else
			System.out.println(-1); //그 외에는 탈출 불가

	} // main

	public static void bfs() {
		int startI = 0;
		int startJ = 0;
		Queue<pMap> queue = new LinkedList<>(); //객체 만들어서 객체 기록 queue 사용
		queue.add(new pMap(startI, startJ, 0, false));
		visited[startI][startJ] = true; //첫 시작 부분 true 초기값
		while (!queue.isEmpty()) {
			pMap tmpPMAP = queue.remove(); //하나 꺼내씀
			for (int a = 0; a < 4; a++) { //4방향 이동
				int newI = tmpPMAP.r + dr[a];
				int newJ = tmpPMAP.c + dc[a];
				if (newI >= 0 && newI < N && newJ >= 0 && newJ < M) {
					if (tmpPMAP.crush) {
						if (!cVisited[newI][newJ]) {

							if (newI == N - 1 && newJ == M - 1) {
								System.out.println(tmpPMAP.time + 2); //도착하면 탈출 처음 들어가는것도시간 1로 쳐서 처음=1, 도착=1 -> +2
								System.exit(0);
							} else {
								cVisited[newI][newJ] = true;
								queue.add(new pMap(newI, newJ, tmpPMAP.time + 1, tmpPMAP.crush));
							}
							// 지나갈 수 있는 길일 때

						}

					} // 부수기 스킬 쓴 이후
					else {
						if (!visited[newI][newJ]) {
							if (map[newI][newJ] == 1) {
								queue.add(new pMap(newI, newJ, tmpPMAP.time + 1, true));

							} // 벽일 때
							else {
								if (newI == N - 1 && newJ == M - 1) {
									System.out.println(tmpPMAP.time + 2);
									System.exit(0);
								} else {
									visited[newI][newJ] = true;
									queue.add(new pMap(newI, newJ, tmpPMAP.time + 1, tmpPMAP.crush));
								}
							} // 지나갈 수 있는 길일 때

						} // visited if
					} // 부수기 스킬 쓰기 전
				} // 범위 밖 안나가나 체크
			} // a for
		} // while
	}

	public static class pMap {
		public int r;
		public int c;
		public int time;
		public boolean crush;

		pMap() {

		}

		pMap(int r, int c, int time, boolean crush) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.crush = crush;
		}

		@Override
		public String toString() {
			return "pMap [r=" + r + ", c=" + c + ", time=" + time + ", crush=" + crush + "]";
		}

	}

}
