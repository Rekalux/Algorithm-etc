package Day1002;

import java.util.Scanner;

public class Boj_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fact[0] = 1;
		fact[1] = 1;
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(factorial(a)/factorial(a-b)/factorial(b));
	}

	static int fact[] = new int[11];

	static int factorial(int n) {
		if (fact[n] != 0) {
			return fact[n];
		}
		return fact[n] = factorial(n - 1) * n;
	}
}
