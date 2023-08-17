
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int strlength = str.length();
        
        String[] strArray = new String[strlength];

        //substring 너무 편함!
        for(int i=0; i<strlength; i++) {
            strArray[i] = str.substring(i, strlength);
        }

        //아스키 코드여서 정렬하면 알아서 알파벳 순 ! 대문자와 소문자 조건 걸면..
        // 일단 이것도 하나의 방법..
        Arrays.sort(strArray);

        for (String strs : strArray) {
            System.out.println(strs);
        }
    }
}
