package Day0923;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		long d = find(a, b, c);
		if (d < 0)
			d += c;
		System.out.println(d);
	}

	static long find(long a, long b, long c) {
		a = a % c;
		if (b == 1) {
			return a;
		}
		if (b == 0) {
			return 1;
		}
		long d = find(a, b / 2, c);
		if (Math.abs(a - c) < a)
			a = a - c;
		if (b % 2 == 0) {
			return (d % c * d % c ) % c;
		} else {
			return ( ( d % c * d % c ) % c * a) % c;
		}
	}
}
