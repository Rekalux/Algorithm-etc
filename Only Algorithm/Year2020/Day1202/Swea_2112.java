package Day1202;

import java.util.Scanner;

public class Swea_2112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();
			boolean a[][] = new boolean[d][w];
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					if (sc.nextInt() == 1) {
						a[i][j] = true;
					}
				}
			}
			result = 13;
			visit = new boolean[d];
			dfs(new film(a, 0),0);
			System.out.println("#" + tc + " " + result);
		}
	}

	static int d, w, k;
	static int result;
	static boolean visit[];

	static void dfs(film f, int get) {
		if (result <= f.dis) {
			return;
		}
		if (test(f.a)) {
			result = f.dis;
			return;
		}
		if(get>=d) {
			return;
		}
		boolean b[] = new boolean[w];
		for (int j = 0; j < w; j++) {
			b[j] = f.a[get][j];
		}
		
		dfs(f,get+1);
		for (int j = 0; j < w; j++) {
			f.a[get][j] = true;
		}
		dfs(new film(f.a, f.dis + 1), get + 1);
		for (int j = 0; j < w; j++) {
			f.a[get][j] = false;
		}
		dfs(new film(f.a, f.dis + 1), get + 1);
		for (int j = 0; j < w; j++) {
			f.a[get][j] = b[j];
		}
	}

	static boolean test(boolean a[][]) {
		for (int i = 0; i < w; i++) {
			int count1 = 0, count2 = 0;
			boolean pass = false;
			for (int j = 0; j < d; j++) {
				if (a[j][i]) {
					count1++;
					count2 = 0;
					if (count1 >= k) {
						pass = true;
					}
				} else {
					count1 = 0;
					count2++;
					if (count2 >= k) {
						pass = true;
					}
				}
			}
			if (!pass) {
				return false;
			}
		}
		return true;
	}

	static class film {
		boolean a[][];
		int dis;

		public film(boolean geta[][], int dis) {
			this.a = new boolean[d][w];
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					this.a[i][j] = geta[i][j];
				}
			}
			this.dis = dis;
		}

	}
}
