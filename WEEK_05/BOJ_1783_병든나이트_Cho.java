package src;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		//���Ʒ��� �Դٰ��� ���������� �޿������� �Դٰ��ٰ� �Ұ����� ���� ����Ʈ
		if (N >= 3 && M >= 7) {
			System.out.println(M-2); //���� ���� 3���� 1~4 ��� ��찡 �����ϸ� ���������� ���� ���� ���� ������ ��ĭ + ���Ʒ��� 2ĭ�� �ݺ� 
		} else if ( N>=3 && M <= 6) { //���ΰ� �ʹ� ª�Ƽ� 1~4�ѹ��� ���ϴ� ��� 
			if ( M <=4) 
			System.out.println(M);
			else 
				System.out.println(4);
		} else if (N == 2) { //���ΰ� 2�� ���Ʒ� 2ĭ���°� �Ұ����� ���
			if (M >=7)
				System.out.println(4);
			else 
				System.out.println(M/2 + M%2);
		} else if (N ==1) { //���ΰ� 1�� ���
			System.out.println(1);
		}
		

	}
}
