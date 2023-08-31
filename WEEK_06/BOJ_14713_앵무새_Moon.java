package BOJ_14713_앵무새;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 1. 애초에 단어 순서가 다를 경우
		 * 2. sentence의 단어들을 기준으로 앵무새의 단어와 짝이 맞는지 검사를 하는 것이므로
		 *    sentence의 단어들을 앵무새가 다 가지고 있는 것은 확인했으나, 앵무새의 단어가 남아있는 경우.
		 */
		
		// input 받기
		int N = sc.nextInt(); // 앵무새 N마리
		String[][] parrots = new String[N][]; // 앵무새 말하는 내용을 이차원배열로 받아올 것
		String dump = sc.nextLine(); // 왜 이렇게 되지
		for (int i = 0; i < N; i++) {
			parrots[i] = sc.nextLine().split(" ");
		}
		int[] peek = new int[N]; // 이건 앵무새가 말한 내용의 단어를 어디까지 사용했는지 queue처럼 사용하기 위한 값들
		String[] sentence = sc.nextLine().split(" "); // 만들어진 문장을 받아온다
		
		// 풀이
		Sol: for (String word : sentence) {
			for (int i = 0; i < N; i++) {
				if (peek[i] >= parrots[i].length) continue; // 만약 이 앵무새가 가진 단어를 다 썼으면 다음 앵무새로
				if (parrots[i][peek[i]].equals(word)) {
					peek[i]++; // 맨 앞에 있는 단어를 가리키는 integer 수정해주기
					continue Sol; // sentence의 다음 단어 검사하기
				}
				
				if (i == N-1) { // 마지막 앵무새가 가진 단어까지 다 비교해봤으나 짝을 찾지 못하면
					break Sol; // 바로 break한다. (Impossible)
				}
			}
			
		}
		
		int cnt = 0; // 통과한 앵무새 수
		int cnt2 = 0; // 통과한 앵무새가 가진 단어 수의 합
		for (int i = 0; i < N; i++) {
			if (peek[i] == parrots[i].length) { // 앵무새가 가진 단어를 다 썼는지. peek이 앵무새가 가진 단어 수만큼 증가되었는지 확인하면 된다.
				cnt++;
				cnt2 +=peek[i];
			}
		}
		// 통과한 앵무새의 수가 총 앵무새의 수와 같고, 단어 수의 합은 sentence의 길이와 같을 때
		if (cnt == N && cnt2 == sentence.length) System.out.println("Possible");
		else System.out.println("Impossible");
		
		sc.close();
	}
}