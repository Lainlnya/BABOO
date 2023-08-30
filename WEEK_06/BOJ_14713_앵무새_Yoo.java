package BOJ_14713_�޹���;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine(); // ���� ���� ó��

		Queue<String>[] queues = new Queue[N];

		// �Էµ� ���� N���� ť�� ����
		for (int i = 0; i < N; i++) {
			queues[i] = new LinkedList<>();
			String sentence = sc.nextLine();
			String[] words = sentence.split(" ");

			for (String word : words) {
				queues[i].add(word);
			}
		}

		// ������ ������ �Է�
		String lastSentence = sc.nextLine();
		String[] lastWords = lastSentence.split(" ");

		boolean possible = true;

		// ������ ���� ���� lastWords �迭���� �ѱ��ھ� ����
		for (String word : lastWords) {
			boolean found = false;

			// ť �鿡�� word ã��!
			for (Queue<String> queue : queues) {
				if (!queue.isEmpty() && queue.peek().equals(word)) {
					queue.poll();
					found = true;
					break;
				}
			}

			// ���� ť���� �ش� �ܾ ã�� ���� ���
			if (!found) {
				possible = false;
				break;
			}
		}

		// �������� .. �ܾ���� ������ ���庸�� �ʰ��ϸ� ��!
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
