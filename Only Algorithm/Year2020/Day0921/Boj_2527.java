package Day0921;

import java.util.Scanner;

public class Boj_2527 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 4; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			// 위는 입력
			String result = "";
			if(c<A || C<a || d<B || D<b) { // d
				result = "d";
			}
			else if( ( c == A || a == C ) && ( d == B || D == b ) ) { // c
				result = "c";
			}
			else if( c == A || a == C  ||  d == B || D == b  ) { // b
				result = "b";
			}
			else { // a
				result = "a";
			}
				System.out.println(result);
		}
	}
}
