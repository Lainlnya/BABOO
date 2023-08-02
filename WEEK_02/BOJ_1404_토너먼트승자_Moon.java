import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] prob = new int[28];
		
		for (int i = 0; i < 28; i++) {
			prob[i] = sc.nextInt() ;
		}
		
		// 각 참가자가 준결승에 올라갈 확률
		int[] sf = { prob[0], 100-prob[0], prob[13], 100-prob[13], 
				prob[22], 100-prob[22], prob[27], 100-prob[27] }; // 10^2
		
//		System.out.println("각 참가자가 준결승전에 올라올 확률");
//		for (int i = 0; i < sf.length; i++) {
//			System.out.print(sf[i]+" ");
//		}
//		System.out.println();
		
		long[] f = { sf[0]*sf[2]*prob[1] + sf[0]*sf[3]*prob[2] ,
				sf[1]*sf[2]*prob[7] + sf[1]*sf[3]*prob[8] , 
				sf[2]*sf[0]*(100-prob[1]) + sf[2]*sf[1]*(100-prob[7]) , 
				sf[3]*sf[0]*(100-prob[2]) + sf[3]*sf[1]*(100-prob[8]) , 
				sf[4]*sf[6]*prob[23] + sf[4]*sf[7]*prob[24] , 
				sf[5]*sf[6]*prob[25] + sf[5]*sf[7]*prob[26] , 
				sf[6]*sf[4]*(100-prob[23]) + sf[6]*sf[5]*(100-prob[25]) , 
				sf[7]*sf[4]*(100-prob[24]) + sf[7]*sf[5]*(100-prob[26]) }; // 10^6
		
//		System.out.println("각 참가자가 결승전에 올라올 확률");
//		for (int i = 0; i < f.length; i++) {
//			System.out.print(f[i]+" ");
//		}
//		System.out.println();
		
		long[] win = { f[0]*( f[4]*prob[3] + f[5]*prob[4] + f[6]*prob[5] + f[7]*prob[6]) , 
				f[1]* ( f[4]*prob[9] + f[5]*prob[10] + f[6]*prob[11] + f[7]*prob[12] ) , 
				f[2]* ( f[4]*prob[14] + f[5]*prob[15] + f[6]*prob[16] + f[7]*prob[17] ) , 
				f[3]* ( f[4]*prob[18] + f[5]*prob[19] + f[6]*prob[20] + f[7]*prob[21] ) , 
				f[4]* ( f[0]*(100-prob[3]) + f[1]*(100-prob[9]) + f[2]*(100-prob[14]) + f[3]*(100-prob[18]) ) , 
				f[5]* ( f[0]*(100-prob[4]) + f[1]*(100-prob[10]) + f[2]*(100-prob[15]) + f[3]*(100-prob[19]) ) , 
				f[6]* ( f[0]*(100-prob[5]) + f[1]*(100-prob[11]) + f[2]*(100-prob[16]) + f[3]*(100-prob[20]) ) , 
				f[7]* ( f[0]*(100-prob[6]) + f[1]*(100-prob[12]) + f[2]*(100-prob[17]) + f[3]*(100-prob[21]) ) }; // 10^12
		
//		System.out.println("각 참가자가 우승 할 확률");
		for (int i = 0; i < win.length; i++) {
			System.out.print((win[i]/Math.pow(10, 14))+" ");
		}

		sc.close();
	}
}