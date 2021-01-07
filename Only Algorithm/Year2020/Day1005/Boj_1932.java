package Day1005;

import java.util.Scanner;

public class Boj_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		int temp;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				temp = sc.nextInt();
				b[j] = a[j] + temp;
				if (j > 0) {
					b[j] = Math.max(b[j], a[j - 1] + temp);
				}
				if (i == (n - 1) && max < b[j]) {
					max = b[j];
				}
			}
			for (int j = 0; j <= i; j++) {
				a[j] = b[j];
			}
		}
		System.out.println(max);
	}
}
