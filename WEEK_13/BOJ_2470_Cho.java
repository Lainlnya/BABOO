package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_Cho {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int pIdx = -1;
		int mIdx = -1;
		int[] plus = new int[N];
		int[] minus = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= 0)
				plus[++pIdx] = num;
			else
				minus[++mIdx] = num;
		}
		// mIdx, pIdx�� �迭�� ������ ����Ű���� ����
		// �÷����� plus�迭�� ���̳ʽ� ���� minus �迭�� ���
		if (pIdx >= 1)
			Arrays.sort(plus, 0, pIdx +1);
		if (mIdx >= 1)
			Arrays.sort(minus, 0, mIdx +1);
		// �ø� ���� ���� ����Ե� �տ� ������ ������ �ʿ��� �¾��� �տ��͵� ������
		int mArr[] = new int[2];
		// �� ��� ���� �׸� �����
		Arrays.fill(mArr, 1000000001);
		if (pIdx >= 1) {
			mArr = near(mArr, plus[0], plus[1]);
		}
		if (mIdx >= 1) {
			mArr = near(mArr, minus[mIdx - 1], minus[mIdx]);
		}
		if (pIdx >= 0 && mIdx >= 0) {
			mArr = near(mArr, plus[pIdx], minus[0]);
			mArr = near(mArr, plus[0], minus[mIdx]);			
		}
		

		// ������ ����ó���� - 2��, +2�� ���� ����, +- �� ���� ���Ѱ��� ��
		int mUpperIdx = 0; // �������� �̱⿡ ����������(- �� ���� ū��) 0���� ��ġ��
		// �׷��� �ö󰡸鼭 üũ�ؾ��ؼ� ���Ӱ� ���� ����
		while (pIdx > 0 || mUpperIdx < mIdx) {
			if (pIdx == -1 || mIdx == -1)
				break;
		 // ���� �ϳ��� �迭�� ����ִٸ� �ǹ� �����Ƿ� �ٷ� Ż��
			mArr = near(mArr, plus[pIdx], minus[mUpperIdx]);
			if (pIdx == 0) {
				mUpperIdx++;
				continue;
			}
			
			if (mUpperIdx == mIdx) {

				pIdx--;
				continue;
			} //�ϳ��� �̹� ���� �����ߴٸ� �ٸ� �ϳ��� ��� ����

			if (plus[pIdx] + minus[mUpperIdx] >= 0) {
				pIdx--;
				continue;
			} else {
				mUpperIdx++;
				continue;
			} //�װ� �ƴ϶�� ���ؼ� +���� �� �Ǵٸ�(���밪��) +���̱�  -�� �� �Ǵٸ� - ���̱�

		}
		Arrays.sort(mArr);
		for (int i = 0; i < 2; i++) {
			System.out.print(mArr[i] + " ");

		}

	}

	static int[] near(int[] near, int a, int b) {
		if (Math.abs(near[0] + near[1]) > Math.abs(a + b))
			return new int[] { a, b };
		else
			return near;
	} // �񱳿� ���Ӱ� ���� �� ���ڰ� ������ ������ �� �迭 ��ȯ
}
