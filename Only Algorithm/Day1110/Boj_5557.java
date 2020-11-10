package Day1110;

import java.util.Scanner;

public class Boj_5557 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		long b[][] = new long[n][21];
		long result = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (i == 0) {
				b[i][a[i]] = 1;
				continue;
			}
			if (i == n - 1) {
				result = b[i-1][a[i]];
				break;
			}
			for (int j = 0; j <= 20; j++) {
				b[i][j] += (0 <= j + a[i] && j + a[i] <= 20) ? b[i - 1][j + a[i]] : 0;
				b[i][j] += (0 <= j - a[i] && j - a[i] <= 20) ? b[i - 1][j - a[i]] : 0;
			}
		}
		System.out.println(result);
	}
}
