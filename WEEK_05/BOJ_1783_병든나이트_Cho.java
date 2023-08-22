package src;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		//위아래는 왔다갔다 가능하지만 왼오른쪽은 왔다갔다가 불가능한 것이 포인트
		if (N >= 3 && M >= 7) {
			System.out.println(M-2); //위로 폭이 3개면 1~4 모든 경우가 가능하며 오른쪽으로 가는 것이 적은 오른쪽 한칸 + 위아래로 2칸을 반복 
		} else if ( N>=3 && M <= 6) { //가로가 너무 짧아서 1~4한번씩 못하는 경우 
			if ( M <=4) 
			System.out.println(M);
			else 
				System.out.println(4);
		} else if (N == 2) { //세로가 2로 위아래 2칸가는게 불가능한 경우
			if (M >=7)
				System.out.println(4);
			else 
				System.out.println(M/2 + M%2);
		} else if (N ==1) { //세로가 1인 경우
			System.out.println(1);
		}
		

	}
}
