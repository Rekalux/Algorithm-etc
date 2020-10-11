package Day1011;

import java.util.Scanner;

public class Boj_5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 1000 - sc.nextInt();
		System.out.println(N / 500 + (N % 500) / 100 + (N % 100) / 50 + (N % 50) / 10 + (N % 10) / 5 + (N % 5));
	}
}
