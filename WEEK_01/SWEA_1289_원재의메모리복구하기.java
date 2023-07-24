import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt(); // 테스트케이스 개수

		for (int i = 0; i < test_case; i++) {
			String str = sc.next();
			char[] memory = str.toCharArray();
			int cnt = 0; // 수정 횟수

			// 1로 시작하면 첫번째 bit를 골라 전체 1로 바꾸기 때문에 +1 증가
			if (memory[0] == '1') {
				cnt++;
			}

			// 0 > 1, 1 > 0으로 바뀌는 횟수만큼 수정해주면 됨!
			for (int len = 0; len < (memory.length - 1); len++) {
				if (memory[len] != memory[len + 1])
					cnt++;
			}

			System.out.println("#" + (i + 1) + " " + cnt);
		}

		sc.close();
	}
}
