package Day0923;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_7579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int app[][] = new int[N + 1][10001];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(app[i], M);
		}
		int a[] = new int[N + 1];
		int b[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
		}
		int last = 10000;
		for (int i = 1; i <= N; i++) {

			for (int j = 0; j <= 10000; j++) {
				int ad = M;
				if (j - a[i] >= 0)
					ad = app[i - 1][j - a[i]] - b[i];
				app[i][j] = Math.min(app[i - 1][j], ad);
				if (app[i][j] <= 0) {
					last = j;
					break;
				}
			}
		}
		System.out.println(last);
	}

}
