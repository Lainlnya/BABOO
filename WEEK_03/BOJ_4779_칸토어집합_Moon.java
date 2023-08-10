package BOJ_4779_칸토어집합;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void Cantor(int n) {
		if (n == 0) {
			sb.append("-");
		} else {
			Cantor(n-1);
			for (int i = 0; i < Math.pow(3, n-1); i++) {
				sb.append(" ");
			}
			Cantor(n-1);
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 4779 칸토어 집합
		 * 얼마나 걸렸는지 모르겠음..
		 * 
		 * StringBuilder를 쓰니까 바로 풀렸다
		 */
		
		File file = new File("src/BOJ_4779_칸토어집합/input.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			Cantor(N);
			String str = sb.toString();
			System.out.println(str);
			sb.setLength(0);
		}

		sc.close();
	}
}