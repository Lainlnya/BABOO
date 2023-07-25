package WEEK01;

import java.util.*;

public class SWEA_1218_괄호짝짓기{
	 // <> [] {} ()
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 //Testcase 10 
		for (int T = 0; T < 10; T++) {
            // N개
            int N = sc.nextInt();
            String input = sc.next();

            int count1 = 0; // (
            int count1_1 = 0; // )
            int count2 = 0; // <
            int count2_1 = 0; // >
            int count3 = 0; // [
            int count3_1 = 0; // ]
            int count4 = 0; // {
            int count4_1 = 0; // }

            for (int i = 0; i < N; i++) {
                char ch = input.charAt(i);

                switch (ch) {
                    case '(':
                        count1++;
                        break;
                    case ')':
                        count1_1++;
                        break;
                    case '<':
                        count2++;
                        break;
                    case '>':
                        count2_1++;
                        break;
                    case '[':
                        count3++;
                        break;
                    case ']':
                        count3_1++;
                        break;
                    case '{':
                        count4++;
                        break;
                    case '}':
                        count4_1++;
                        break;
                }
            }

            if (count1 == count1_1 && count2 == count2_1 && count3 == count3_1 && count4 == count4_1) {
                System.out.println("#" + (T + 1) + " 1");
            } else {
                System.out.println("#" + (T + 1) + " 0");
            }
        }
        sc.close();
    }
}