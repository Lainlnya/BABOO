package BOJ_14713_앵무새;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine(); // 개행 문자 처리

		Queue<String>[] queues = new Queue[N];

		// 입력된 문장 N개의 큐에 저장
		for (int i = 0; i < N; i++) {
			queues[i] = new LinkedList<>();
			String sentence = sc.nextLine();
			String[] words = sentence.split(" ");

			for (String word : words) {
				queues[i].add(word);
			}
		}

		// 마지막 문장을 입력
		String lastSentence = sc.nextLine();
		String[] lastWords = lastSentence.split(" ");

		boolean possible = true;

		// 마지막 문장 받은 lastWords 배열에서 한글자씩 따기
		for (String word : lastWords) {
			boolean found = false;

			// 큐 들에서 word 찾기!
			for (Queue<String> queue : queues) {
				if (!queue.isEmpty() && queue.peek().equals(word)) {
					queue.poll();
					found = true;
					break;
				}
			}

			// 이전 큐에서 해당 단어를 찾지 못한 경우
			if (!found) {
				possible = false;
				break;
			}
		}

		// 예외조건 .. 단어개수가 마지막 문장보다 초과하면 땡!
		for (Queue<String> queue : queues) {
			if (!queue.isEmpty()) {
				possible = false;
				break;
			}
		}

		if (possible) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
	}
}
