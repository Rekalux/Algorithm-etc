package Day0922;

import java.util.Scanner;

public class Boj_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n[] = new int[1000001];
		int g = sc.nextInt();
		n[1] = 0;
		int a, b, c;
		for (int i = 2; i <= g; i++) {
			a = Integer.MAX_VALUE;
			b = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				a = n[i / 3] + 1;
			}
			if (i % 2 == 0) {
				b = n[i / 2] + 1;
			}
			c = n[i - 1] + 1;
			n[i] = Math.min(a, Math.min(b, c));
		}
		System.out.println(n[g]);
	}
}
