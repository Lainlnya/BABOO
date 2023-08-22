package src;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		//세로 길이 가 가장 중요 세로길이 위주로 나눠줌
		if (N >= 3 && M >= 7) {
			System.out.println(M-2); //세로길이가 3, 가로길이가 7이상이면 모든 경우가 가능, 오른쪽으로 최대한 적게 가야하므로 위아래2개씩 반복하기
		} else if ( N>=3 && M <= 6) { // 4가지 이동 전부 할 수는 없는 경우
			if ( M <=4) 
			System.out.println(M);
			else 
				System.out.println(4);
		} else if (N == 2) { //세로가 2로 2가지 이동만 할 수 있는 경우
			if (M >=7)
				System.out.println(4);
			else 
				System.out.println(M/2 + M%2);
		} else if (N ==1) { //세로가 1로 움직일 수 없는 경우
			System.out.println(1);
		}
		

	}
}
