package Day1001;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int an = sc.nextInt();
		int a[] = new int[an];
		for (int i = 0; i < an; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int bn = sc.nextInt();
		int temp;
		for (int i = 0; i < bn; i++) {
			temp = sc.nextInt();
			if (Arrays.binarySearch(a, temp) >= 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
