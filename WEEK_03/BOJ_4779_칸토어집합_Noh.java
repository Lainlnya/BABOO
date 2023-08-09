package WEEK_03;

import java.util.Scanner;

public class BOJ_4779_칸토어집합_Noh {

	static String[] ans;

	public static String cantor(int len) {
		if (len == 1)
			ans[len] = "-";
		else {
			String side = cantor(len / 3);
			// center만 String에서 StringBuilder로 바꾸니까 메모리 초과 바로 해결;;
			StringBuilder center = new StringBuilder();
			for (int i = 0; i < len / 3; i++) {
				center.append(" ");
			}
			ans[len] = side + center + side;

		}
		return ans[len];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// sc.hasNext() 다음 입력이 없으면 멈춤
		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			if (N == -1) {
				break;
			}

			int len = (int) Math.pow(3, N);

			ans = new String[len + 1];
			System.out.println(cantor(len));
		}
	}
}
