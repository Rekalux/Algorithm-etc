package Day1013;

import java.util.*;

public class Boj_1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		int n = sc.nextInt();
		int l = sc.nextInt();
		int v = sc.nextInt() - 1;
		int x, y;
		int a[][] = new int[n][n];
		for (int i = 0; i < l; i++) {
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			a[x][y] = 1;
			a[y][x] = 1;
		}
		s.add(v);
		int m;
		boolean[] visit = new boolean[n];
		visit[v] = true;
		System.out.print((v+1)+" ");
		con : while (!s.isEmpty()) {
			m = s.peek();
			for (int i = 0; i < n; i++) {
				if (a[m][i] == 0 || visit[i]) {
					continue;
				} else {
					s.push(i);
					visit[i] = true;
					System.out.print((i + 1) + " ");
					continue con;
				}
			}
			s.pop();
		}
		System.out.println();
		visit = new boolean[n];
		visit[v] = true;
		q.add(v);
		while (!q.isEmpty()) {
			m = q.poll();
			System.out.print((m + 1) + " ");
			for (int i = 0; i < n; i++) {
				if (a[m][i] == 0 || visit[i]) {
					continue;
				} else {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}
