import java.util.Scanner;

public class Main {
	
	public static int factorial(int num) {
		if (num <= 1) {
			return 1;
		} else {
			return num*factorial(num-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 1~N 까지의 수 중
		int M = sc.nextInt(); // 서로 다른 M개의 수를 골랐을 때
		int K = sc.nextInt(); // 적어도 K개의 수가 같으면 당첨입니다.
		
		double NN = (double) N;
		double MM = (double) M;
		

		
		int i = 0;
		double prob = 0;
		
		while (M-i >= K) { // M개의 같은 숫자를 뽑는 경우부터 (M-1), (M-2), ... , K개의 같은 숫자를 뽑는 경우까지
			double probl = 1;
			for (int j = 0; j < M; j++) { // 공 M개 뽑을 확률 각각 계산하는 부분
				if (M-j > i) { // 같은 공을 뽑는 확률
					probl *= (MM-j)/(NN-j);
				} else { // 다른 공을 뽑는 확률
					probl *= (NN-(j+i))/(NN-j);
				}
			}
			probl *= factorial(M)/(factorial(M-i)*factorial(i));
			prob +=probl;
			i++;
		}
		
		System.out.println(prob);
		
		sc.close();
	}
}