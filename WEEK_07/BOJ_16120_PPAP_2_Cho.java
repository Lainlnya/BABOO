
import java.util.Scanner;
import java.util.Stack;

public class BOJ_16120_PPAP_2_Cho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (str.contains("PPAP")) {
            str = str.replaceFirst("PPAP", "P");
        } //ppap는 앞에서부터 찾으면서 바꿔주기만하면됨 바꿈과 동시에 영향을 받으므로 다시 앞에서 부터 ppap 찾아서 p로바꿔주기
        if (str.equals("P")) {
            System.out.println("PPAP"); //다 바꾼뒤 p이면 끝
        } else {
            System.out.println("NP"); //다 바꿨는데 p가 아니면 탈락
        } //시간 초과
    }
}