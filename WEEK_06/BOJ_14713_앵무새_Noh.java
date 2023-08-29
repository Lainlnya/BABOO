package BOJ_14713_앵무새;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 각 앵무새가 말한 문장을 배열로 저장
		List<Queue<String>> total = new ArrayList<>();

		int N = sc.nextInt(); // 앵무새의 수
		sc.nextLine(); // 입력받기 다음 줄로 바꿈

		for (int i = 0; i < N; i++) {
			// 앵무새 마다 새로운 큐 생성
			Queue<String> parrot = new LinkedList<>();

			String[] str = sc.nextLine().split("\\s");
			for (int j = 0; j < str.length; j++) {
				// 공백으로 구분해서 한 단어씩 큐에 추가
				parrot.add(str[j]);
			}
			total.add(parrot);
		}

		String[] takedown = sc.nextLine().split("\\s"); // 받아 적은 문장
		String ans = "Possible";

		outer: for (int i = 0; i < takedown.length; i++) {
			boolean flag = false;
			f1: for (int j = 0; j < total.size(); j++) {
				if (takedown[i].equals(total.get(j).peek())) {
					total.get(j).remove();
					flag = true;
					break f1;
				}
			}
			if (flag == false) {
				ans = "Impossible";
				break outer;
			}
		}

		// 여기까지 왔는데도 각 앵무새 큐에 단어가 남아있으면 불완전한 문장
		for (int i = 0; i < total.size(); i++) {
			if (total.get(i).size() != 0) {
				ans = "Impossible";
			}
		}

		System.out.println(ans);

	} // main

} // class
