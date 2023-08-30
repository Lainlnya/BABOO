package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14713_앵무새 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		List<Queue<String>> queues = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			queues.add(new LinkedList<>());
		} //queue 리스트 생성

		for (int i = 0; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			while (st.hasMoreTokens()) {
				queues.get(i).add(st.nextToken());
			} //빌때까지 받아오면서 queue에 값들 넣어주기
		}
		Outer: while (!queues.get(N).isEmpty()) {
			String str = queues.get(N).peek();
			for (int i = 0; i < N; i++) {
				if (str.equals(queues.get(i).peek())) {
					queues.get(N).remove();
					queues.get(i).remove();
					continue Outer;
				} 

			}
			System.out.println("Impossible");
			System.exit(0);
		} //빌때까지 queue list를 돌면서 같은 게있으면 둘다 빼주고 같은게 아예없으면 바로 출력후 종료
		boolean tF = true;
		for (int i = 0; i < N + 1; i++) {
			if (!queues.get(i).isEmpty())
				tF = false;
		} // 모든 queue가 비어있어야 문제의 표현되로 된 것이므로 tF검사
		if (tF) {
			System.out.println("Possible");

		} else {
			System.out.println("Impossible");
		} // 출 력

	}
}
