package BOJ_6198_옥상정원꾸미기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		/*
		 * 빌딩의 높이를 순차적으로 받아오고, stack에 넣어준다.
		 * 단, stack 안에 들어간 빌딩들의 높이가 새로 들어갈 빌딩의 높이보다 모두 높아야 한다.
		 * 그렇지 않으면 새로 들어갈 빌딩보다 낮은 높이의 빌딩들이 stack에서 없어질 때까지 모두 pop한다.
		 * 해당 빌딩의 높이가 stack에 들어갈 때 이미 들어있던 빌딩들의 수를 모두 더한 값이 답이 된다.
		 * (해당 빌딩보다 작은 번호를 갖으며, 높이가 높은 빌딩이라는 뜻)
		 */
		
		Stack<Integer> building = new Stack<>();
		long ans = 0; // 빌딩의 개수가 8만까지인 걸 long이 필요할 듯 하다 (최대 32억?)
		
		for (int i = 0; i < N; i++) {
			
			int curr = sc.nextInt(); // 다음 빌딩의 높이
			
			if (!building.isEmpty()) { // stack이 비어있지 않으면서
				if (building.get(building.size()-1) > curr) { // stack의 마지막 빌딩이 현재 빌딩보다 높을 때에는
					ans +=building.size(); // 넣기 전 stack에 들어있던 빌딩 수를 ans에 더해주면서
					building.push(curr); // 그냥  stack에 넣어준다.
				} else {
					// stack의 마지막 빌딩이 현재 빌딩보다 낮거나 같을 때에는
					// 현재 빌딩보다 낮은 빌딩이 없어질 때까지 stack에서 pop한다.
					// 이와 같은 과정을 계속 거쳤으므로 stack 안의 빌딩들의 높이는 내림차순이며,
					// 가장 바깥쪽 빌딩 높이가 현재 빌딩보다 낮아지기만 하면 조건을 만족한다.
					while (!building.isEmpty() && building.get(building.size()-1) <= curr) building.pop();
					ans +=building.size(); // 마찬가지로 새로운 빌딩을 넣기 전 stack에 들어있던 빌딩 수를 ans에 더해주면서
					building.push(curr); // stack에 넣어준다.
				}
			} else building.push(curr); // 만약 stack이 완전히 비어있는 상태라면 그냥 넣어준다.
		}
		
		System.out.println(ans);
		sc.close();
	}
}