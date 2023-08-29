package BOJ_5464_주차장;

//import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주차 공간의 수
		int[] space = new int[N]; // 주차 공간
		Queue<Integer> wait = new LinkedList<>();

		int M = sc.nextInt(); // 차량의 수

		int[] price = new int[N]; // 주차 공간들의 단위당 무게 요금
		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
		}

		int[] weight = new int[M]; // 차량들의 무게
		for (int i = 0; i < M; i++) {
			weight[i] = sc.nextInt();
		}

		int income = 0; // 총 수입
		int cnt = N; // 현재 주차공간의 여유공간

		for (int i = 0; i < 2 * M; i++) {
			int order = sc.nextInt();
			if (order > 0) { // 양수일 때
				if (cnt > 0) { // 여유공간 있으면 주차
					// 숫자가 가장 작은 주차 공간 찾기
					for1: for (int j = 0; j < N; j++) {
						if (space[j] == 0) {
							space[j] = order; // 그 자리에 주차하고
							cnt--; // 여유공간-1
							income += price[j] * weight[order - 1]; // 주차비 정산
							break for1;
						}
					}
				} else { // 여유공간이 없으면 큐에서 대기
					wait.add(order);
				}
//				System.out.println(Arrays.toString(space));
			} else if (order < 0) { // 음수일 때
				for2: for (int j = 0; j < N; j++) {
					if ((-1) * order == space[j]) {
						space[j] = 0; // 공간 비워주고
						cnt++; // 여유공간+1
						if (wait.size() > 0) { // 큐에서 대기하는 자동차가 있으면
							int next = wait.remove(); // 큐에서 대기중이였던 차 빼서
							space[j] = next; // 바로 그자리에 주차하고
							cnt--; // 여유공간-1
							income += price[j] * weight[next - 1]; // 주차비 정산
						}
						break for2;
					}
				}
//				System.out.println(Arrays.toString(space));
			}
		} // 주차하고 빼는 for문

		System.out.println(income);

	} // main

} // class
