package BOJ_6198_옥상정원꾸미기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		Long cnt = (long) 0; // 관리인들이 벤치마킹 가능한 빌딩의 수 합

		int N = sc.nextInt(); // 빌딩의 개수

		// 첫 번째 건물을 벤치마킹 할 수 있는 관리인은 없음!
		stack.push(sc.nextInt());

		for (int i = 0; i < N - 1; i++) {
			// 그 다음 빌딩의 높이 받아와서
			int height = sc.nextInt();
			// 스택이 비어있지 않고, 받아온 높이보다 작거나 같은 높이들은 다 pop해줌
			while (!stack.isEmpty() && height >= stack.peek()) {
				stack.pop();
			}
			// 내가 push되기 전에 남아있는 건물의 수가 내 건물을 볼 수 있는 관리인의 수
//			System.out.println("!" + stack);
			cnt += stack.size();

			// 내 건물 높이 push
			stack.push(height);
		} // 각 빌딩의 높이 입력받아서 계산
		System.out.println(cnt);
	} // main
} // class
