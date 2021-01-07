package Day1001;

import java.util.Scanner;

public class Boj_2475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int t = sc.nextInt();
			sum += t * t;
		}
		System.out.println(sum % 10);
	}
}
