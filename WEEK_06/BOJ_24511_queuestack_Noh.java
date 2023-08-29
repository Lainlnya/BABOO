package BOJ_24511_queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Integer> queuestack = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());// queuestack를 구성하는 자료구조의 개수
		int[] A = new int[N]; // (0이면 큐, 1이면 스택)

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 큐이면 저장, 스택이면 바로 pop하기때문에 저장할 필요 없음
			if (A[i] == 0)
				queuestack.addLast(num);
		}

		int M = Integer.parseInt(br.readLine()); // 삽입할 수열의 길이
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			queuestack.addFirst(Integer.parseInt(st.nextToken())); // 맨 앞에 넣고
			int pop = queuestack.removeLast(); // 맨 뒤에서 빼기
			sb.append(pop).append(" ");
		}
		System.out.print(sb);

	} // main
} // class
