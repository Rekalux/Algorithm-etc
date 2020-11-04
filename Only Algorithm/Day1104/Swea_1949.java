package Day1104;

import java.util.Scanner;

public class Swea_1949 {
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int n, k, a[][], max,maxdis;
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			maxdis = 0;
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int[n][n];
			max = 0;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
					if (max < a[i][j]) {
						max = a[i][j];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (max == a[i][j]) {
						dfs(new mountain(j, i, 1, max, false));
					}
				}
			}
			System.out.println("#"+tc+" "+maxdis);

		}
	}

	static void dfs(mountain mo) {
		if (visit[mo.y][mo.x]) {
			return;
		}
		visit[mo.y][mo.x] = true;
		if( mo.dis > maxdis) {
			maxdis = mo.dis;
		}
		for (int i = 0; i < 4; i++) {
			int ny = mo.y + dy[i];
			int nx = mo.x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
				continue;
			}
			if(mo.low) { // 깎은 경우
				if(mo.size > a[ny][nx]) { // 크기가 작은 경우에만
					dfs(new mountain(nx,ny,mo.dis+1,a[ny][nx],true));
				}
			}
			else {
				if(mo.size > a[ny][nx]) {
					dfs(new mountain(nx,ny,mo.dis+1,a[ny][nx],false));
				}
				else {
					if(mo.size > a[ny][nx]-k) {						
						dfs(new mountain(nx,ny,mo.dis+1,mo.size-1,true));
					}
				}
			}
		}
		visit[mo.y][mo.x] = false;
	}
}

class mountain {
	int x;
	int y;
	int dis;
	int size;
	boolean low;

	public mountain(int x, int y, int dis, int size, boolean low) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.size = size;
		this.low = low;
	}
}