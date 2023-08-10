import java.util.Scanner;

public class BOJ_4779_Cantor_Yoo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        while (sc.hasNext()) {
            int N = sc.nextInt();
            String str = "-";
            
            for (int i = 0; i < N; i++) {
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    repeated.append(" ");
                }
//                공백 증가 확인
//                System.out.println("공백 확인 :" + repeated+"이만큼");
                str = str + repeated.toString() + str;
            }
            
            System.out.println(str);
        }
    }
}

// Math.pow (3,N) 사용하면 시간초과 .. ㅠㅠ
// 약간 묻고 더블로 가! 방식인듯
// N =3 이라고 생각 했을 때, i =0; str = - -로 생성
// i =1 ; (- -)   (- -) 세덩이 생성
// i =2 ; {(- -)   (- -)}(같은 length 만큼의 공백){(- -)   (- -)}
//이해는 되는데 내가 백지에서 StringBuilder 사용할 짬이 안된다 ...