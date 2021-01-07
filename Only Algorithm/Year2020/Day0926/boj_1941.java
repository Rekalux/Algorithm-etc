package Day0926;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1941 {
	static int YS[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		YS = new int[5][5];
		for (int i = 0; i < 5; i++) {
			String temp = sc.next();
			for (int j = 0; j < 5; j++) {
				if (temp.charAt(j) == 'S') {
					YS[i][j] = 1;
				}
			}
		}
		find(0, 0, new int[7]);
		System.out.println(result);
	}

	static int result = 0;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int[][] map = new int[5][5];
	static boolean visit[][] = new boolean[5][5];
	static Queue<Point> q = new LinkedList<Point>();
	static int nx, ny;

	static void find(int s, int a, int[] list) {
		if (s == 7) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[i][j] = 0;
				}
			}
			int Y = 0;
			int X = 0;
			for (int i = 0; i < 7; i++) {
				Y = list[i] / 5;
				X = list[i] % 5;
				map[Y][X] = 1;
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					visit[i][j] = false;
				}
			}
			int count = 0;
			int all = 0;
			q.add(new Point(X, Y));
			visit[Y][X] = true;
			
			while (!q.isEmpty()) {
				Point p = q.poll();
				all++;
				if (YS[p.y][p.x] == 1) {
					count++;
				}
				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];
					if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
						continue;
					}
					if (visit[ny][nx]) {
						continue;
					}
					if (map[ny][nx] == 0) {
						continue;
					}
					visit[ny][nx] = true;
					q.add(new Point(nx, ny));
				}
			}
			if (all == 7 && count >= 4) {
				result++;
				
			}
			return;
		}
		if (a >= 25) {
			return;
		}
		list[s] = a;
		find(s + 1, a + 1, list);
		find(s, a + 1, list);
	}
}
