package BOJ_13335_트럭;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	/*
	 * 다리를 건너지 못한 트럭들의 무게를 trucks라는 queue에 담아두고, 다리를 건널 때마다 하나씩 꺼낸다.
	 * 다리 위에 있는 트럭들은 bridge라는 integer배열에 저장해, 단위 시간마다 한 칸 씩 앞쪽으로 이동시킨다.
	 * 이 때, 다리 위의 트럭들의 무게 합은 bridgeWeight라는 integer에 매 시간마다 갱신한다.
	 * bridge[0]에 도착한 트럭은 다음 시간에 배열에서 삭제됨과 동시에 arrived라는 queue에 저장된다.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 트럭 수 N
		int W = sc.nextInt(); // 다리 길이 W
		int L = sc.nextInt(); // 다리의 최대 하중 L
		
		Queue<Integer> trucks = new LinkedList<>(); // 아직 출발하지 못한 트럭들의 무게
		for (int i = 0; i < N; i++) trucks.add(sc.nextInt());
		int[] bridge = new int[W]; // 다리 위의 트럭들의 무게
		Queue<Integer> arrived = new LinkedList<>(); // 다리를 다 건너 반대편에 도착한 트럭들의 무게
		int bridgeWeight = 0; // 다리 위의 트럭들의 무게 합
		int time = 0; // 소요 시간
		
		while (arrived.size() != N) { // 모든 트럭이 반대편에 다 도착할 때 까지
			time++; // 매 과정을 반복할 때마다 소요 시간을 ++해줌
			if (bridge[0] != 0) { // 다리 끝에 도착한 트럭이 있다면
				arrived.add(bridge[0]); // 다리 끝의 트럭 무게를 arrived에 저장
				bridgeWeight -=bridge[0]; // 다리 위 트럭 무게 합에서 제외해 줌
				bridge[0] = 0; // 다리 끝에 있던 트럭 무게는 삭제해 줌
			}
			for (int i = 1; i < W; i++) bridge[i-1] = bridge[i]; // 다리 위의 모든 트럭 앞으로 한 칸 씩 이동
			bridge[W-1] = 0; // 위와 같은 방법으로 이동시키면 다리 맨 첫칸을 0으로 따로 초기화를 해 줄 필요가 있음
			if (trucks.size() != 0 && bridgeWeight + trucks.peek() <= L) {
				// 대기중인 트럭이 아직 남아있고, 현재 다리 위 트럭 무게 합에다가 이번에 들어올 트럭 무게를 더해도 최대 하중보다 작거나 같다면
				bridge[W-1] = trucks.poll(); // 다리 위로 올라와도 됨
				bridgeWeight +=bridge[W-1]; // 무게도 추가해 줌
			}
		}
		
		System.out.println(time); // 그럴 때 걸린 총 시간을 출력해주세요
		
		sc.close();
	}
}