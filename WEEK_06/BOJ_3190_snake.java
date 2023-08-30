package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3190_snake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N + 2][N + 2];
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int aI = sc.nextInt();
			int aJ = sc.nextInt();
			arr[aI][aJ] = 1;
		}

		int time = 0; //시간 기록

		int M = sc.nextInt();// while 문 내의 새로운 값 받아올 때 사용
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int newI = 1;
		int newJ = 2; // //초기값(시간1초)
		arr[1][1] = 7; // //뱀은 기니까 7로 표현
		int direction = 1; // 초기방향 = 오른쪽
		Queue<Integer> queueI = new LinkedList<>();
		Queue<Integer> queueJ = new LinkedList<>();
		queueI.add(1); // 
		queueJ.add(1); //  queue 2개만들어서 각각 i, j 값 기록
 		int T = sc.nextInt(); // 방향 설정 시간 받아오기
		int m = 1; //내부 T받아올때 쓰기위함 hasNext같은거와 동일
		while (newI > 0 && newI < N + 1 && newJ > 0 && newJ < N + 1 && arr[newI][newJ] != 7) {
			time++;
//			System.out.printf("I:%d J: %d time : %d ", newI, newJ, time);
//			System.out.println();
			queueI.add(newI);
			queueJ.add(newJ); //새로운 값 queue에 기록
			if (arr[newI][newJ] == 0) {
				arr[queueI.poll()][queueJ.poll()] = 0;
			} //칸이 비어있으면 queue에서 꺼내서 비워주고, 칸이 차있으면(사과면) 냅두기
			// while조건상 뱀이면 여기로 안들어옴
			arr[newI][newJ] = 7; //새로운칸 뱀으로 채우기
			if (time == T) { //방향 전환 시간 도달시
				m++;
				String d = sc.next(); //방향 전환 방향받고
				switch (d) { //구분
				case "D":
					direction = (direction+1)%4;
					break;
				case "L":
					direction = (direction+3)%4;
					break; //처음에 위 오른쪽 아래 왼쪽 다 되는줄 알고 받아와서 그냥 그거 사용 
				}
				if (m < M * 2) { //방향 전환값 있으면 받아오기
					T = sc.nextInt();
					m++;
				}
			}
			
			newI += dr[direction];
			newJ += dc[direction];
			// ����ġ ���
		}
		System.out.println(time+1); //뱀이 벽에 부딛히기 전에 나오기 때문에 부딛히는 시간 1초
		System.exit(0); // 입력값이 남아있어도 빠져나오는 알고리즘이 불안해서 강제종료
	}
}
