package WEEK_03;

import java.util.Scanner;

public class BOJ_4779_Cantor_kim {
    public static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            sb = new StringBuilder();
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
        int left = num / 3;
        for (int i = start + left; i < start + left * 2; i++) {
            sb.setCharAt(i, ' ');
        }

        recursive(start, left); // 왼쪽 (0 ~ 1)
        recursive(start + 2 * left, left); // 오른쪽 (2 ~ 3)
    }
}
