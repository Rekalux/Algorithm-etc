package Day0923;

import java.util.Scanner;

public class boj_2564 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		int num[] = new int[n + 1];
		int w = 2 * (r + c);
		for (int i = 0; i <= n; i++) {
			int a = sc.nextInt();
			int p = sc.nextInt();
			if (a == 1) {
				num[i] = p;
			} else if (a == 2) {
				num[i] = w - c - p;
			} else if (a == 3) {
				num[i] = w - p;
			} else {
				num[i] = r + p;
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int m = Math.abs(num[i] - num[n]);
			sum += Math.min(m, w - m);
		}
		System.out.println(sum);
	}
}
