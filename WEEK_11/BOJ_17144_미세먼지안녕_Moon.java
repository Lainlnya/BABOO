package BOJ_17144_미세먼지안녕;

import java.util.Scanner;

public class Main {

	static int R, C;
	static int[][] room;
	static int purifier;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input 받기
		R = sc.nextInt();
		C = sc.nextInt();
		int T = sc.nextInt();

		// 초기 방 상태 저장
		room = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] = sc.nextInt();
				// 공기청정기 위치 저장
				if (room[r][c] == -1 && purifier == 0) {
					// r행 0열, (r+1)행 0열에 공기청정기가 설치되어있다는 뜻
					purifier = r;
				}
			}
		}

		// T초 반복
		for (int i = 0; i < T; i++) {
			circulation();
		}
		
		// 출력
		int ans = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				//System.out.print(room[r][c]+" ");
				if (room[r][c] != -1) {
					ans +=room[r][c];
				}
			}
			//System.out.println();
		}
		System.out.println(ans);
		
		sc.close();
	}

	public static void circulation() {
		int[][] temp = new int[R][C];
		
		// 1. 확산
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				
				// 확산되는 미세먼지
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (Range(nr, nc)) {
						cnt++;
						temp[nr][nc] +=room[r][c]/5;
					}
				}
				
				// 확산되지 않고 남아있는 미세먼지
				temp[r][c] += (room[r][c] - cnt*(room[r][c]/5));
			}
		}
		
		// 2. 공기청정기 작동
		// 위쪽
		// 공기를 전달받는 곳의 좌표
		int urr = purifier -1;
		int urc = 0;
		int udir = 0;
		// 다시 공기청정기를 만날 때까지
		while (room[urr][urc] != -1) {
			// 공기를 전달해주는 곳의 좌표
			int ugr = urr + dr[udir];
			int ugc = urc + dc[udir];
			// 그 전달해주는 좌표가 공기청정기의 위치랑 같을 경우에는 깨끗한 공기를 전달받고 반복을 종료
			if (ugr == purifier && ugc == 0) {
				temp[urr][urc] = 0;
				break;
			}
			// 전달해주는 좌표가 유효하지 않을 경우에는 방향을 바꿈
			if (!Range(ugr, ugc) || ugr > purifier) {
				udir = upper(udir);
				ugr = urr + dr[udir];
				ugc = urc + dc[udir];
			}
			// 공기를 전달해주고 전달해준 좌표가 이제 공기를 전달받을 차례
			temp[urr][urc] = temp[ugr][ugc];
			urr = ugr;
			urc = ugc;
		}
		// 아래쪽
		// 공기를 전달받는 곳의 좌표
		int lrr = purifier +2;
		int lrc = 0;
		int ldir = 2;
		// 다시 공기청정기를 만날 때까지
		while (room[lrr][lrc] != -1) {
			// 공기를 전달해주는 곳의 좌표
			int lgr = lrr + dr[ldir];
			int lgc = lrc + dc[ldir];
			// 그 전달해주는 좌표가 공기청정기의 위치랑 같을 경우에는 깨끗한 공기를 전달받고 반복을 종료
			if (lgr == purifier+1 && lgc == 0) {
				temp[lrr][lrc] = 0;
				break;
			}
			// 전달해주는 좌표가 유효하지 않을 경우에는 방향을 바꿈
			if (!Range(lgr, lgc) || lgr <= purifier) {
				ldir = lower(ldir);
				lgr = lrr + dr[ldir];
				lgc = lrc + dc[ldir];
			}
			// 공기를 전달해주고 전달해준 좌표가 이제 공기를 전달받을 차례
			temp[lrr][lrc] = temp[lgr][lgc];
			lrr = lgr;
			lrc = lgc;
		}

		// 3. 방 상태 업데이트
		room = temp;
	}
	
	// 좌표의 유효성 검사
	public static boolean Range(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			if (room[r][c] != -1) {				
				return true;
			}
		}
		return false;
	}
	
	// 방의 위쪽 공기 순환 방향 결정
	public static int upper(int dir) {
		dir++;
		if (dir == 4) return 0;
		return dir;
	}
	
	// 방의 아래쪽 공기 순환 방향 결정
	public static int lower(int dir) {
		dir--;
		if (dir == -1) return 3;
		return dir;
	}
}