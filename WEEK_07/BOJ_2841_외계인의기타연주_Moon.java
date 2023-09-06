package BOJ_2841_외계인의기타연주;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //멜로디에 포함된 음의 수
		sc.nextInt(); //프렛의 수 P 필요 없어서 저장하지 않음
		
		Stack<Integer>[] guitar = new Stack[6]; //누르고 있는 프렛 정보
		for (int i = 0; i < 6; i++) guitar[i] = new Stack<Integer>();
		
		int move = 0;
		
		for (int melody = 0; melody < N; melody++) {
			
			int line = sc.nextInt() -1; //눌러야 할 줄 번호
			int flat = sc.nextInt(); //눌러야 할 프렛 번호
			
			// 더 높은 음의 프렛을 누르고 있는 경우
			while (guitar[line].size() != 0 && guitar[line].get(guitar[line].size()-1) > flat) {
				guitar[line].pop();
				move++;
			}
			
			// 같은 음을 이미 누르고 있는 경우
			if (guitar[line].size() != 0 && guitar[line].get(guitar[line].size()-1) == flat) continue;
				
			// 새로운 음을 눌러야 하는 경우
			guitar[line].push(flat);
			move++;
			
		} //melody
		
		System.out.println(move);
		sc.close();
	}
}