import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.next());
        int pCount = 0;
        for (int idx = 0 ; idx < str.length() ; idx++) {
            if (str.charAt(idx) == 'P') {
                pCount++;
                //처음에 P이면 P의 개수 +1
            } else if (str.charAt(idx) =='A') {
            	// A를 만나면 ppap구조상 무조건 뒤에 p가 나와야 함
                if ( idx+1 >=str.length() || str.charAt(idx+1) == 'A') {
                    System.out.println("NP");
                    System.exit(0);
                    //따라서 a로 끝나거나 그 다음에 a가 연달아나오면 NP
                } else {
                    if(pCount >=2) {
                        pCount--;
                        idx++;
                        // ppap이므로 이미 pCount가 2이상이야만 ppap만들기 가능
                    } else {
                        System.out.println("NP");
                        System.exit(0);
                    } // 즉 p가 1개이하면 이 역시 NP

                }

            }
        }
        if (pCount ==1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        } //ppap -> p로 계속 바꿔나가 결국 p가 1개가 되면 답 그외에는 x
    }
}

