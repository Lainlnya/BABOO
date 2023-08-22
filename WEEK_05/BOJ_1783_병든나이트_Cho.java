package src;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		if (N >= 3 && M >= 7) {
			System.out.println(M-2);
		} else if ( N>=3 && M <= 6) {
			if ( M <=4)
			System.out.println(M);
			else 
				System.out.println(4);
		} else if (N == 2) {
			if (M >=7)
				System.out.println(4);
			else 
				System.out.println(M/2 + M%2);
		} else if (N ==1) {
			System.out.println(1);
		}
		

	}
}
