package asdf;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 북극곰괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//입력받는 괄호 개수
		int N = sc.nextInt();
		
		//괄호를 string 으로 입력받기
		String str = sc.next();
		Stack<Character> stack = new Stack<>();

		//괄호 홀수면 무조건 불가넝
		if (N % 2 != 0) {
			System.out.println(-1);
		} else {

			//그 과정을 진행하고나서의 size를 배열로 입력받아 추적
			int[] size = new int [N];
			
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);

				if (ch == '(') {
					if (stack.isEmpty()) {
						stack.add('(');
						
					} else if (stack.peek() == ')') {
						stack.pop();
						
					} else {
						stack.add('(');
						
					}
				} else if (ch == ')') {
					if (stack.isEmpty()) {
						stack.add(')');
						
					} else if (stack.peek() == '(') {
						stack.pop();
					
					} else {
						stack.add(')');
					
					}
				}
				
				//add, pop 하고나서 size 값을 저장
				size[i]=stack.size();
				
			} // 반복문 끝
			
			//가장 큰 size 값이 결국 나이테 처럼 괄호 누적된 것을 알 수 있음.
			int max = 0;
			for (int i = 0; i < N; i++) {
				if (size[i] > max) {
					max = size[i];
				}
			}
			
			if (stack.isEmpty()) {
				System.out.println(max);
			} else {
				System.out.println(-1);
			}
		}
	}// 메인 끝
}

