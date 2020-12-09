package Day1209;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Boj_3709 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			a = new int[n + 2][n + 2];
			for (int i = 0; i < m; i++) {
				int aa = sc.nextInt();
				int bb = sc.nextInt();
				a[aa][bb] = -1;
			}
			int sy = sc.nextInt();
			int sx = sc.nextInt();

			set = new HashSet[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					set[i][j] = new HashSet<Integer>();
				}
			}

			// y가 n보다 크면, 위
			// y가 1보다 작으면, 아래
			// x가 1보다 작으면, 오른쪽
			// x가 n보다 크면, 왼쪽
			int dir = 0;
			if (sy > n) {
				dir = 3;
			} else if (sy < 1) {
				dir = 1;
			} else if (sx > n) {
				dir = 2;
			}
			ansx = 0;
			ansy = 0;
			dfs(sy, sx, dir);

			System.out.println(ansy + " " + ansx);
		}
	}

	static int a[][];
	static int n;
	// 오, 아래, 왼, 위
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static HashSet<Integer> set[][];
	static int ansx = 0, ansy = 0;

	static void dfs(int y, int x, int dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		// 범위를 넘어가면 나간 것
		if (ny < 1 || ny > n || nx < 1 || nx > n) {
			ansx = nx;
			ansy = ny;
			return;
		}
		if (set[ny][nx].contains(dir)) {
			ansx = 0;
			ansy = 0;
			return;
		}
		set[ny][nx].add(dir);
		// 거울을 만났을 때
		if (a[ny][nx] == -1) {
			dfs(ny, nx, (dir + 1) % 4);
		} else {
			dfs(ny, nx, dir);
		}
	}
}
