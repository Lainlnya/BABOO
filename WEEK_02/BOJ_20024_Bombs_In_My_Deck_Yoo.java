import java.util.*;

public class BOJ_20024_Bombs_In_My_Deck_Yoo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 전체 쥐고 있는 카드 수
        int B = sc.nextInt(); // 카드 수 중에 숨겨진 폭탄 수
        int C = sc.nextInt(); // 남은 hp 폭탄 고르면 -5hp, 0되면 사망

        // 특수 조건, B*5보다 C가 크면 무조건 승리 확률 1
        // 폭탄 다 골라도 체력이 남음
        if (C > B * 5) {
            System.out.println(1);
        } else {
            // 지기 위한 카운팅 ...
            int count = 0;
            for (int i = 1; i < 7; i++) {
                if (5 * i < C) {
                    count++;
                } else {
                	count++;
                    break;
                }
            } //한방에 죽는경우 배제
            if(count ==1) {
            	System.out.println(1 - (double) B / A);
            }
            else {
            	
            int num = 1;
            int num1 = 1;
            for (int i = 0; i < count; i++) {
                num = num*(A-i);
                num1 = num1*(B-i);
            }
            
            System.out.println(1 - (double) num1 / num);
            }
        }
    }
}
