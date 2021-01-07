package Day0917;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1707 {
	static int N, M;
	static int a;
	static ArrayList<Integer> list[];
	static Queue<Integer> q;
	static int visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a, b;
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			list = new ArrayList[N + 1];
			visit = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				list[a].add(b);
				list[b].add(a);
			}

			q = new LinkedList<Integer>();
			q.add(1);
			visit[1] = 1;
			result = true;
			while (!q.isEmpty()) {
				while (!q.isEmpty()) {
					bfs(q.poll());
					if (!result)
						break;
				}
				if (!result)
					break;
				for (int i = 1; i <= N; i++) {
					if (visit[i] == 0) {
						q.add(i);
						visit[i] = 1;
						break;
					}
				}

			}

			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");

		}
	}

	static boolean result = true;
	static int dn;

	public static void bfs(int n) {

		for (int i = 0; i < list[n].size(); i++) {
			dn = list[n].get(i);
			if (visit[n] == visit[dn]) {
				result = false;
				return;
			} else if (visit[dn] != 0) {
				continue;
			}
			visit[dn] = 3 - visit[n];
			q.add(dn);
		}
	}

}