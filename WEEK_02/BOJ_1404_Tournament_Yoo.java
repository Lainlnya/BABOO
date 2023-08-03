import java.util.Arrays;
import java.util.Scanner;

public class tonur {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int [] arr1 = new int[28];
		for(int i=0; i<28; i++) {
			arr1[i] = sc.nextInt();
		}
		//왼쪽 경기
		double[] semi1 = new double[8]; // 순서 : 당장 처음 이길 확률 , 준결승에서 이길확률 , 준결승 상대가 올라올 확률
		semi1[0] = (arr1[0] / 100.0) * (arr1[1] / 100.0)* (arr1[13]/100.0); // 0이 결승 진출 확률 (2가 3을 이기고 준결승 경우)
		semi1[1] = (arr1[0] / 100.0) * (arr1[2] / 100.0)* (1-arr1[13]/100.0); // 0이 결승 진출 확률 (3이 2를 이기고 준결승 경우)
		semi1[2] = (1- arr1[0] / 100.0) * (arr1[7] / 100.0)* (arr1[13]/100.0); // 1이 결승 진출 확률 (2가 3을 이기고 준결승 경우)
		semi1[3] = (1- arr1[0] / 100.0) * (arr1[8] / 100.0)* (1-arr1[13]/100.0); // 1이 결승 진출 확률 (3이 2를 이기고 준결승 경우)
		semi1[4] = (arr1[13] / 100.0) * (1- arr1[1] / 100.0)* (arr1[0]/100.0); // 2 결승 진출 확률 (0가 1을 이기고 준결승 경우)
		semi1[5] = (arr1[13] / 100.0) * (1- arr1[7] / 100.0)* (1- arr1[0]/100.0); // 2 결승 진출 확률 (1가 0을 이기고 준결승 경우)
		semi1[6] = (1-arr1[13] / 100.0) * (1-arr1[2] / 100.0)* (arr1[0]/100.0); // 3 결승 진출 확률 (0가 1을 이기고 준결승 경우)
		semi1[7] = (1-arr1[13] / 100.0) * (1-arr1[8] / 100.0)* (1-arr1[0]/100.0); // 3 결승 진출 확률 (1가 0을 이기고 준결승 경우)

		double[] final1 = new double[4];
		final1[0] = semi1[0] + semi1[1]; // 0's probability to reach the final
		final1[1] = semi1[2] + semi1[3]; // 1's probability to reach the final
		final1[2] = semi1[4] + semi1[5]; // 2's probability to reach the final
		final1[3] = semi1[6] + semi1[7]; // 3's probability to reach the final

		// 오른쪽 경기
		double[] semi2 = new double[8]; // 순서 : 당장 처음 이길 확률 , 준결승에서 이길확률 , 준결승 상대가 올라올 확률
		semi2[0] = (arr1[22] / 100.0) * (arr1[23] / 100.0) * (arr1[27] / 100.0); // 4 결승 진출 확률 (6가 7을 이기고 준결승 경우)
		semi2[1] = (arr1[22] / 100.0) * (arr1[24] / 100.0) * (1- arr1[27] / 100.0); // 4 결승 진출 확률 (7가 6을 이기고 준결승 경우)
		semi2[2] = (1-arr1[22] / 100.0) * (arr1[25] / 100.0) * (arr1[27] / 100.0); // 5 결승 진출 확률 (6가 7을 이기고 준결승 경우)
		semi2[3] = (1-arr1[22] / 100.0) * (arr1[26] / 100.0) * (1-arr1[27] / 100.0); // 5 결승 진출 확률 (7가 6을 이기고 준결승 경우)
		semi2[4] = (arr1[27] / 100.0) * (1- arr1[23] / 100.0) * (arr1[22] / 100.0); // 6 결승 진출 확률 (4가 5을 이기고 준결승 경우)
		semi2[5] = (arr1[27] / 100.0) * (1- arr1[25] / 100.0) * (1-arr1[22] / 100.0); // 6 결승 진출 확률 (5가 4을 이기고 준결승 경우)
		semi2[6] = (1-arr1[27] / 100.0) * (1- arr1[24] / 100.0) * (arr1[22] / 100.0); // 7 결승 진출 확률 (4가 5을 이기고 준결승 경우)
		semi2[7] = (1-arr1[27] / 100.0) * (1- arr1[26] / 100.0) * (1-arr1[22] / 100.0); // 7 결승 진출 확률 (5가 4을 이기고 준결승 경우)
		
		double[] final2 = new double[4];
		final2[0] = semi2[0] + semi2[1]; // 4's probability to reach the final
		final2[1] = semi2[2] + semi2[3]; // 5's probability to reach the final
		final2[2] = semi2[4] + semi2[5]; // 6's probability to reach the final
		final2[3] = semi2[6] + semi2[7]; // 7's probability to reach the final
		
		double zerowin = 0;
		double onewin = 0;
		double twowin = 0;
		double threewin = 0;
		double fourwin = 0;
		double fivewin = 0;
		double sixwin = 0;
		double sevenwin = 0;
		
		for(int i=0; i<4; i++) {
			zerowin += final1[0]*final2[i]*(arr1[3+i]/100.0);
			onewin += final1[1]*final2[i]*(arr1[9+i]/100.0);
			twowin += final1[2]*final2[i]*(arr1[14+i]/100.0);
			threewin += final1[3]*final2[i]*(arr1[18+i]/100.0);
		}
		fourwin= final2[0]*(final1[0]*(1-arr1[3]/100.0)+final1[1]*(1-arr1[9]/100.0)+final1[2]*(1-arr1[14]/100.0)+final1[3]*(1-arr1[18]/100.0));
		fivewin= final2[1]*(final1[0]*(1-arr1[4]/100.0)+final1[1]*(1-arr1[10]/100.0)+final1[2]*(1-arr1[15]/100.0)+final1[3]*(1-arr1[19]/100.0));
		sixwin= final2[2]*(final1[0]*(1-arr1[5]/100.0)+final1[1]*(1-arr1[11]/100.0)+final1[2]*(1-arr1[16]/100.0)+final1[3]*(1-arr1[20]/100.0));
		sevenwin= final2[3]*(final1[0]*(1-arr1[6]/100.0)+final1[1]*(1-arr1[12]/100.0)+final1[2]*(1-arr1[17]/100.0)+final1[3]*(1-arr1[21]/100.0));
		
		
		System.out.println(zerowin);
		System.out.println(onewin);
		System.out.println(twowin);
		System.out.println(threewin);
		System.out.println(fourwin);
		System.out.println(fivewin);
		System.out.println(sixwin);
		System.out.println(sevenwin);
	}
}