package BOJ_11656_���̻�迭;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int strlength = str.length();
        
        String[] strArray = new String[strlength];

        //substring ¯ ����!
        for(int i=0; i<strlength; i++) {
            strArray[i] = str.substring(i, strlength);
        }

        //��Ʈ �ϸ� ���ĺ� �� ���� !!
        Arrays.sort(strArray);

        for (String strs : strArray) {
            System.out.println(strs);
        }
    }
}
