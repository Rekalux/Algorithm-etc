package Day0923;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj_11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			BigInteger p[] = new BigInteger[251];
			p[0] = BigInteger.ONE;
			p[1] = BigInteger.ONE;
			for (int i = 2; i <= n; i++) {
				p[i] = p[i - 1].add(p[i - 2]).add(p[i - 2]);
			}
			System.out.println(p[n]);
		}
	}
}