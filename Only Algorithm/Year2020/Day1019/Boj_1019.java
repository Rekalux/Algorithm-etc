package Day1019;

import java.util.Scanner;

public class Boj_1019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		int result = 0;
		for (int i = 0; i < 8; i++) {
			s = sc.next();
			for (int j = 0; j < 8; j++) {
				if (s.charAt(j) == 'F' && (i + j) % 2 == 0) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
