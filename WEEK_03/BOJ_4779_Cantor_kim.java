package WEEK_03;

import java.util.Scanner;

public class BOJ_4779_Cantor_kim {
    public static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            sb = new StringBuilder();
            // 출력해야 할 총 숫자를 구한 다음 "-"를 찍기
            int Total = (int)Math.pow(3, sc.nextInt());
            for (int i = 0; i < Total; i++) {
                sb.append("-");
            }

            recursive(0, Total);
            System.out.println(sb);
        }
    }

    public static void recursive(int start, int num) {
        if (num == 1) {
            return;
        }
        
        // 3등분 해서 가운데는 빈 문자열(' ')으로 만들어주기
        int left = num / 3;
        for (int i = start + left; i < start + left * 2; i++) {
            sb.setCharAt(i, ' ');
        }

        // 남은 왼쪽 재귀
        recursive(start, left);
        // 남은 오른쪽 재귀
        recursive(start + 2 * left, left);
    }
}
