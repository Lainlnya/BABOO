package BOJ_1213_팰린드롬만들기;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//입력단 tocharArray 사용
		String str = sc.next();
		char[] ch = str.toCharArray();
		int strLength = str.length();

		//우선 사전순 정렬이기때문에 스타트를 사전순으로 시작!
		Arrays.sort(ch);

		//첫번째 값은 무조건 첫 사전 단어임! 팰린드롬 절반까지 진행하기 국룰
		for (int i = 0; i < strLength / 2; i++) {
			//한개 찾고 나면 그 이후부터 앞 뒤 한칸씩 감소해서 탐색
			for (int j = i; j < strLength - i; j++) {
				//같은걸 찾았으면 제일 자리 바꿈 (i로 연관지어서)
				//바꾸고 나면 첫, 끝자리 제외한 나머지 중간 문자들 다시 arraysort 사전순 정렬
				if (ch[j] == ch[i]) {
					char ch1 = ch[strLength - i - 1];
					ch[strLength - i - 1] = ch[j];
					ch[j] = ch1;
					
					//자리바꿈 끝나면 사전순 초기화
					if (j < strLength / 2) {
						Arrays.sort(ch, j, strLength - i - 1);
					}
				}
			}
		}

		//팰린드롬인지 찾기위한 카운트변수
		int cnt = 0;

		//짝수 길이 일때 팰린드롬 탐색 다르면 cnt++ 
		if (strLength % 2 == 0) {
			for (int i = 0; i < strLength / 2; i++) {
				if (ch[i] != ch[strLength - i - 1])
					cnt++;
			}
			//다를때 cnt ++ 했으니까 실패!
			if (cnt > 0) {
				System.out.println("I'm Sorry Hansoo");
			} else {
				for (int i = 0; i < strLength; i++) {
					System.out.print(ch[i]);
				}
				sc.close();
			}

		} else if (strLength % 2 == 1) {

			if (strLength == 1) {
				System.out.println(str);
			} else {

				for (int i = 0; i < strLength / 2; i++) {
					if (ch[i] != ch[strLength - i - 1])
						cnt++;
				}

				if (cnt > 0) {
					System.out.println("I'm Sorry Hansoo");
				} else {
					for (int i = 0; i < strLength; i++) {
						System.out.print(ch[i]);
					}
					sc.close();
				}

			}

		}
	}
}