import java.util.*;

public class BOJ_20024_Bombs_In_My_Deck_Yoo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // ��ü ��� �ִ� ī�� ��
        int B = sc.nextInt(); // ī�� �� �߿� ������ ��ź ��
        int C = sc.nextInt(); // ���� hp ��ź ���� -5hp, 0�Ǹ� ���

        // Ư�� ����, B*5���� C�� ũ�� ������ �¸� Ȯ�� 1
        // ��ź �� ��� ü���� ����
        if (C > B * 5) {
            System.out.println(1);
        } else {
            // ���� ���� ī���� ...
            int count = 0;
            for (int i = 1; i < 7; i++) {
                if (5 * i < C) {
                    count++;
                } else {
                	count++;
                    break;
                }
            } //�ѹ濡 �״°�� ����
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
