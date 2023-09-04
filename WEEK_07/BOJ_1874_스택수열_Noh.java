package BOJ_1874_스택수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Stack<Integer> stack = new Stack<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 자연수 개수
		int num = 1; // 스택에 넣을 숫자
		for (int i = 0; i < N; i++) {
			// 수열을 차례로 입력받아서
			int now = sc.nextInt();
			// 스택이 비어있거나, 넣을 숫자가 입력받은 숫자보다 작거나 같으면
			while (stack.isEmpty() || num <= now) {
				// 스택에 넣고
				stack.push(num++);
				sb.append("+\n");
			}
			// 스택에 가장 마지막으로 들어간 숫자가 입력받은 숫자와 같으면
			if (stack.peek() == now) {
				// 스택에서 빼고
				stack.pop();
				sb.append("-\n");
			}
		}
		// 끝났을 때 스택이 비어있으면 만들 수 있는 수열, 아니면 만들 수 없는 수열
		if (stack.isEmpty()) {
			System.out.println(sb);
		} else
			System.out.println("NO");
	} // main
} // class
