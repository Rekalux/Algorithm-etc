package Day1027;

import java.util.Scanner;

public class Boj_1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int sign = 1;
		int sum = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='-') {
				result += (sum * sign);
				sign = -1;
				sum = 0;
			}
			else if(s.charAt(i)=='+') {
				result += (sum * sign);
				sum = 0;
			}
			else {
				sum *= 10;
				sum += (s.charAt(i)-'0');
			}
		}
		result += (sum * sign);
		System.out.println(result);
	}
}
