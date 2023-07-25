import java.util.Scanner;

public class NewCalculation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
			
		for (int i = 0; i < T; i++) { // Test case 반복

			int p = sc.nextInt();
			int q = sc.nextInt(); // 숫자 p, q값 받기
			
			int ptemp = 0;
			int qtemp = 0; // 격자점으로 나타내기 위해 필요한 숫자
			
			while (true) {
				ptemp++;
				if ((p-ptemp) > 0) {
					p -=ptemp;
				} else {
					break;
				}
			} // 1빼고 2빼고 3빼고 ,,, 격자점 값 찾기 : (p, ptemp-p+1)
			
			while (true) {
				qtemp++;
				if ((q-qtemp) > 0) {
					q -=qtemp;
				} else {
					break;
				}
			} // q도 마찬가지
			
			int ansx = p + q;
			int ansy = (ptemp - p + 1) + (qtemp - q + 1);
			// 두 격자점을 더함
			
			int ans = 0;
			
			for (int j=1; j<=(ansx+ansy-2); j++) {
				ans +=j;
			}
			ans +=ansx;
			// 다시 숫자로 변환
			
			System.out.println("#"+(i+1)+" "+ans);
			
		}
		
		sc.close();
	}
} //1hr
