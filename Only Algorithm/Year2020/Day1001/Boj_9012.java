package Day1001;

import java.util.Scanner;
import java.util.Stack;

public class Boj_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		out: for (int i = 0; i < n; i++) {
			String s = sc.next();
			Stack<Boolean> q = new Stack<Boolean>();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					q.add(true);
				} else {
					if (q.isEmpty()) {
						System.out.println("NO");
						continue out;
					}
					q.pop();
				}
			}
			if (q.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}