package BOJ_1966_������ť;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// ����
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int count = 0;
			// �ڷ��� ����
			int N = sc.nextInt();
			// ã������ �ڷ�
			int M = sc.nextInt();
			
			LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
			
			int i = 0;
			while (i < N) {
				// �ε���, �켱����
				Integer[] arr = { i, sc.nextInt() };
				// ť�� �߰�
				queue.add(arr);
				i++;
			}

			// �� ù��° ������
			// ���ü� ������ ������ (�ε��� ��ġ -> ���� ������)
			// ���� �� ������ �ڷ� ������

			while (!queue.isEmpty()) {
				//ó���� ������
				Integer[] now = queue.poll();
				boolean popCan = true;

				for (Integer[] q : queue) {
					// �켱������ �� ������
					if (q[1] > now[1])
						popCan = false;
				}
				// �켱������ �� ���� ���Ұ� ������

				if (popCan) {
					count++;
					if (now[0] == M) {
						sb.append(count).append("\n");
						break;
					}

				} else
					queue.add(now);
			}
		}
		System.out.print(sb);
	}
}

