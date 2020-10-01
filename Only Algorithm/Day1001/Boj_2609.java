package Day1001;

import java.util.Scanner;

public class Boj_2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int aa = a;
		int bb = b;
		while (aa != bb) {
			if (aa < bb)
				bb = bb - aa;
			else
				aa = aa - bb;
		}
		System.out.println(aa);
		System.out.println(a/aa*b);
	}
}
