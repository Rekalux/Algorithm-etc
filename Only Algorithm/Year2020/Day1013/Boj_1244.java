package Day1013;

import java.util.Scanner;

public class Boj_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean a[] = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (sc.nextInt() == 1)
				a[i] = true;
		}
		int m = sc.nextInt();
		int x, y;
		for (int i = 0; i < m; i++) {
			if (sc.nextInt() == 1) {
				x = sc.nextInt();
				y = x;
				while (x < n + 1) {
					a[x] = !a[x];
					x += y;
				}
			} else {
				x = sc.nextInt();
				a[x] = !a[x];
				y = 1;
				while (1 <= x - y && x + y < n + 1 && a[x - y] == a[x + y]) {
					a[x - y] = !a[x - y];
					a[x + y] = !a[x + y];
					y++;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (i % 20 == 1 && i != 1) {
				System.out.println();
			}
			if (a[i] == true) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}

		}
	}

}
