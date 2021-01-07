package Day1018;

import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Boj_13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		Deque<Integer> dq = new LinkedBlockingDeque<Integer>();
		int n[] = new int[100001];
		Arrays.fill(n, -1);
		n[a] = 0;
		dq.add(a);
		int get;
		int temp;
		while (!dq.isEmpty()) {
			get = dq.pollFirst();
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					temp = get * 2;
				} else if (i == 1) {
					temp = get - 1;
				} else {
					temp = get + 1;
				}
				if (temp < 0 || temp > 100000) {
					continue;
				}
				if (n[temp] >= 0) {
					continue;
				}
				if (i == 0) {
					n[temp] = n[get];
					dq.addFirst(temp);
				} else {
					n[temp] = n[get] + 1;
					dq.addLast(temp);
				}
			}
		}
		System.out.println(n[b]);
	}
}