package BOJ_1874_스택수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		/*
		 * 1~N 순서대로 나오는 숫자들을 stack을 이용해 입력받은 숫자 순서와 같게 바꿔주는 방법을 찾는 문제이다.
		 * 입력받은 숫자 순서를 반대로 1~N 내림차순으로 바꿔주는 방법을 찾아 그 역순을 정답으로 제시한다.
		 */
		int N = sc.nextInt();
		Stack<Integer> wait = new Stack<>(); // 입력받은 수열을 입력받은 순서대로 stack에 넣어줌
		Stack<Integer> make = new Stack<>(); // 1~N까지 순서를 만들기 위해 필요한 stack
		Stack<String> answer = new Stack<>(); // 어떤 순서로 push, pop 해야하는지 기록한다.
		
		for (int i = 0; i < N; i++) wait.add(sc.nextInt()); // 입력받은 수열
		
		int num = N; // 정렬을 기다리고 있는 숫자 개수 (if num=8이면 8이 정렬될 차례라는 뜻)
		while (num != 0) {
			// 뽑기
			if (make.size() > 0 && make.get(make.size()-1) == num) {
				// make stack에 뽑아낼 숫자가 있고, 뽑아낼 숫자가 num(이번에 정렬될 차례인 숫자)과 같다면
				make.pop();
				answer.add("+"); // 답은 이 과정과 반대로 제시해야 하므로 pop이지만 +를 기록
				num--; // 다음 정렬될 숫자
				continue;
			}
			// 더 이상 넣을 숫자가 없음
			if (wait.size() == 0) { // 뽑을 수도, 넣을 수도 없으면 수열을 만들 수 없는 경우
				System.out.println("NO");
				System.exit(0);
			}
			// 넣기
			make.add(wait.pop()); // 뽑을 수 없으면 넣는다.
			answer.add("-"); // 반대로 저장하므로 add지만 -를 기록
		}
		
		for (int i = answer.size()-1; i >= 0; i--) {
			sb.append(answer.get(i)+"\n"); // 저장된 answer를 역순으로 출력한다.
		}
		System.out.println(sb);
		sc.close();
	}
}