
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_14235_크리스마스 선물_Yoo
{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 우선순위 큐
		PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();

			// 0일 경우!
			if (a == 0) {
				// 비었으면 -1
				if (queue.isEmpty()) {
					System.out.println(-1);
				}
				// 아니면 큐 폴!
				else {
					System.out.println(queue.poll());
				}
			}
			// 0이 아니면 입력 넣기!
			else {
				for (int j = 0; j < a; j++) {
					int present = sc.nextInt();
					queue.add(present);
				}
			}
		}
	}
}
