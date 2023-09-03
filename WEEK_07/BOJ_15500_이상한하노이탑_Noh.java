package BOJ_15500_이상한하노이탑;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static int cnt = 0; // 원판을 옮긴 횟수
	public static Stack<Integer> first = new Stack<>();
	public static Stack<Integer> second = new Stack<>();
	public static Stack<Integer> third = new Stack<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원판의 개수
		int maxDisk = N; // 현재 옮겨야 할 가장 큰 원반

		// 첫 번째 장대에 차례로 push
		for (int i = 0; i < N; i++) {
			first.push(sc.nextInt());
		}
		while (maxDisk != 0) {
//			System.out.println(first + " " + second + " " + third);
			// 첫 번째 장대에 가장 큰 원반이 있다면
			if (first.contains(maxDisk)) {
				// 가장 큰 원반이 나올때까지 두 번쨰 장대에 원반을 옮기고
				if (first.peek() != maxDisk) {
					cnt++;
					second.push(first.pop());
					sb.append("1 2\n");
				} else { // 가장 큰 원반이 나왔으면
					// 3번 장대로 옮기고
					cnt++;
					third.push(first.pop());
					sb.append("1 3\n");
					// 가장 큰 원반의 숫자를 - 1 해줌!
					maxDisk--;
				}
			} else if (second.contains(maxDisk)) {
				// 가장 큰 원반이 나올때까지 첫 번째 장대에 원반을 옮기고
				if (second.peek() != maxDisk) {
					cnt++;
					first.push(second.pop());
					sb.append("2 1\n");
				} else { // 가장 큰 원반이 나왔으면
					// 3번 장대로 옮기고
					cnt++;
					third.push(second.pop());
					sb.append("2 3\n");
					// 가장 큰 원반의 숫자를 - 1 해줌!
					maxDisk--;
				}
			}
		} // 옮기는 과정

		System.out.println(cnt);
		System.out.println(sb);
	} // main
} // class
