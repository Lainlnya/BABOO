package boj_양;

import java.util.*;

/*
 * ( . ) 이것은 빈 공간
 * ( # ) 이것은 울타리
 * ( o ) 이것은 양
 * ( v ) 이것은 늑대
 * 
 *  # 로 공간이 구분!
 *  늑대보다 양이 많다면 양이 늑대 잡아먹음
 *  아니면 늑대가 양 꺼억
 */

public class Main {

	static boolean[][] visited;
	static char backyard[][];
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int sheep, wolf, cntO, cntV, R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 마당 행
		R = sc.nextInt();
		// 마당 열
		C = sc.nextInt();

		backyard = new char[R][C];
		
		// 마당 입력 완료
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				backyard[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (backyard[i][j] == '#')
					continue;
				
				// 울타리가 아니면 영역 탐색!
				else {
				//cntO = 양 마리수 , cntV = 늑대 수
				cntO = 0;
				cntV = 0;
				
				Find(i, j);
				
				// 양> 늑대  ,, 양 생존
				// 양 < 늑대 ,, 늑대 생존
				
				if (cntO > cntV) {
					sheep += cntO;
				} else
					wolf += cntV;
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	
	//탐색 드가자!
	static void Find(int r, int c) {

		// 양 ++
		if (backyard[r][c] == 'o')
			cntO++;

		// 늑대 ++
		if (backyard[r][c] == 'v')
			cntV++;
		
		// 다하고 나면 울타리로 변환
			backyard[r][c] = '#';

		for (int d = 0; d < 4; d++) {
			int rr = r + dx[d];
			int cc = c + dy[d];
			
			// 범위를 벗어날 경우
			if (rr < 0 || cc < 0 || cc >= C || rr >= R)
				continue;
			
			// 울타리가 있을 경우
			if (backyard[rr][cc] == '#')
				continue;

			Find(rr, cc);
		}
	}

}