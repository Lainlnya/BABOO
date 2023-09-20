package BOJ_6593;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dl = { 0, 0, 0, 0, 1, -1 };
	static int[] dr = { 1, -1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };
	
	static int L, R, C;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) { //받을 거있으면 한 번 더 반복
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L ==0) 
				break;
			char[][][] map = new char[L][R][C];
			int[] startPoint = new int[3]; // 시작 포인트 입력
			int[] endPoint = new int[3]; // 출구 포인트 입력
			visited = new boolean[L][R][C]; //들어갔는지 확인
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k); //charAT활용해서 char값으로 넣어두기
						if (map[i][j][k] == '#') {
							visited[i][j][k] = true;
						} else if (map[i][j][k] == 'S') {
							startPoint[0] = i;
							startPoint[1] = j;																												
							startPoint[2] = k;
						} else if (map[i][j][k] == 'E') {
							endPoint[0] = i;
							endPoint[1] = j;
							endPoint[2] = k;
						} //출발지점 도착지점 표시
					} // k for
				} // j for
				br.readLine(); //필요없는 한 줄 날려버리기
				 
			} // i for
				// 입력 끝
			
			bfs(startPoint, map);
			if (!visited[endPoint[0]][endPoint[1]][endPoint[2]])
				System.out.println("Trapped!"); //출구 방문못했으면 Trapped 출력
			st = new StringTokenizer(br.readLine()); //다음 값이 있으면 반복하기 위해 미리 받아옴
		} // while
	} // main

	public static void bfs(int[] startPoint, char[][][] map) {
		int startI = startPoint[0];
		int startJ = startPoint[1];
		int startK = startPoint[2]; //시작 지점 기록
		Queue<pMap> queue = new LinkedList<>(); //객체를 만들어서 사용
		queue.add(new pMap(startI, startJ, startK, 0));
		visited[startI][startJ][startK] = true;
		Outer: while (!queue.isEmpty()) {
			pMap tempPMap = queue.remove();
			int tI = tempPMap.l;
			int tJ = tempPMap.r;
			int tK = tempPMap.c;
			for (int a = 0; a < 6; a++) {
				int newI = tI + dl[a];
				int newJ = tJ + dr[a];
				int newK = tK + dc[a];
				if (newI >= 0 && newI < L && newJ >= 0 && newJ < R && newK >= 0 && newK < C) {
					if (map[newI][newJ][newK] == 'E') {
						visited[newI][newJ][newK] = true;
						int exitTime = tempPMap.time + 1;
						System.out.println("Escaped in " + exitTime + " minute(s).");
						queue.clear();
						break Outer;
					} else if (map[newI][newJ][newK] == '.') {
						if (!visited[newI][newJ][newK]) {
							visited[newI][newJ][newK] = true;
							queue.add(new pMap(newI, newJ, newK, tempPMap.time + 1));
						} //bfs기초 갈 수 있는 방법 6가지 각각 해보기. 지점 이동할 때 시간 추가
					}
				} //if

			} //a for

		}
	}

	public static class pMap {
		public int l;
		public int r;
		public int c;
		public int time;

		pMap() {

		}

		pMap(int l, int r, int c, int time) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

}
