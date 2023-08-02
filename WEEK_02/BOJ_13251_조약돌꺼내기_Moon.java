import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt(); // M개 종류의 조약돌 색
		
		double N[] = new double[M]; // 각 색상의 조약돌이 N개씩 들어있다.
		int total = 0; // 총 조약돌 개수
		for (int i = 0 ; i < M; i++) {
			N[i] = sc.nextDouble();
			total += N[i];
		}
		
		int K = sc.nextInt(); // 그 중에서 K개를 뽑는다.
		
		double prob = 0;
		for (int i = 0; i < M; i++) {
			double probl = 1;
			for (int j = 0; j < K; j++) {
				probl *=(N[i]-j)/(total-j);
			}
			prob +=probl;
		}
		
		System.out.println(prob);
		
		sc.close();
	}
}