package Day1202;

import java.util.ArrayList;
import java.util.Scanner;

public class Swea_2814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			list = new ArrayList[n];
			result = 1;
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				list[start - 1].add(end - 1);
				list[end - 1].add(start - 1);
			}
			for (int i = 0; i < n; i++) {
				visit = new boolean[n];
				dfs(new loc(i, 1));
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	static ArrayList<Integer> list[];
	static int result = 1;
	static boolean visit[];

	static void dfs(loc l) {
		visit[l.here] = true;
		for (int j = 0; j < list[l.here].size(); j++) {
			if (visit[list[l.here].get(j)]) {
				continue;
			}
			if (result < l.dis + 1) {
				result = l.dis + 1;
			}
			dfs(new loc(list[l.here].get(j), l.dis + 1));
		}
		visit[l.here] = false;
	}

	static class loc {
		int here;
		int dis;

		public loc(int here, int dis) {
			this.here = here;
			this.dis = dis;
		}
	}
}
