package Day1102;

import java.util.Scanner;

public class Swea_1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			int b[] = new int[m];
			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			if (n > m) { // 긴 것을 m으로 교체
				n = n ^ m ^ (m = n);

				int temp[] = b;
				b = a;
				a = temp;
			}

			int max = -999999999;
			for (int i = 0; i < m - n + 1; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += (a[j] * b[i+j]);
				}
				if(max < sum) {
					max = sum;
				}
			}
			System.out.println("#"+(tc+1)+" "+max);

		}

	}
}
