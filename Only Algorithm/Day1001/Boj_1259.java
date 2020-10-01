package Day1001;

import java.util.Scanner;

public class Boj_1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int m = n;
			int n2 = 0;
			while (m > 0) {
				n2 = (n2 * 10) + (m % 10);
				m /= 10;
			}
			if (n2 - n == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
