package BOJ_11656_접미사배열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int strlength = str.length();
        
        String[] strArray = new String[strlength];

        //substring 짱 편함!
        for(int i=0; i<strlength; i++) {
            strArray[i] = str.substring(i, strlength);
        }

        //소트 하면 알파벳 순 정렬 !!
        Arrays.sort(strArray);

        for (String strs : strArray) {
            System.out.println(strs);
        }
    }
}
