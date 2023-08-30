package BOJ_5464_������;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// N�� �ٿ� ���Դ� ��� �迭
		int[] cost = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}

		// M�� �ٿ� ���� �迭
		int[] car = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			car[i] = sc.nextInt();
		}

		// N�� ���� ��Ȳ �迭
		int[] now = new int[N + 1];

		int result = 0;

		// ��⿭
		Queue<Integer> queue = new LinkedList<>();

		run : for (int i = 0; i < 2 * M; i++) {
			int nowCar = sc.nextInt();

			// ������ ��
			if (nowCar > 0) {
				for (int j = 1; j < N + 1; j++) {
					if (now[j] == 0) {
						 // ���� ����
						now[j] = nowCar;
						continue run;
					}
				}
				// ���ڸ��� ������ ��⿭ ť�� ����
				queue.offer(nowCar); 
			} else { // ������ �����
				for (int j = 1; j < N + 1; j++) {
					if (now[j] == nowCar * (-1)) {
						// �ش� �ڸ� ���� �� ���
						now[j] = 0; 
						result += cost[j] * car[nowCar * -1];
						
						//ť ������ �� �� �о�ֱ�
						if (!queue.isEmpty())
							now[j] = queue.poll();
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
