package Day1029;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_3055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int map[][] = new int[y][x];
		Queue<point> q = new LinkedList<point>();
		for (int i = 0; i < y; i++) {
			String s = sc.next();
			for (int j = 0; j < x; j++) {
				if (s.charAt(j) == '*') {
					map[i][j] = -1;
					q.add(new point(j, i));
				} else if (s.charAt(j) == 'D') {
					map[i][j] = -2;
				} else if (s.charAt(j) == 'S') {
					map[i][j] = 1;
				} else if (s.charAt(j) == 'X') {
					map[i][j] = -3;
				}
			}
		}
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		out: for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (map[i][j] == 1) {
					q.add(new point(j, i));
					break out;
				}
			}
		}
		int nx, ny;
		int result = 0;
		out: while (!q.isEmpty()) {
			point p = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = dy[i] + p.y;
				nx = dx[i] + p.x;
				if (nx < 0 || ny < 0 || nx >= x || ny >= y) {
					continue;
				}
				if (map[ny][nx] == 0) {
					map[ny][nx] = (map[p.y][p.x] == -1 ? -1 : map[p.y][p.x] + 1);
					q.add(new point(nx, ny));
				} else if (map[ny][nx] == -2 && map[p.y][p.x] > 0) {
					result = map[p.y][p.x];
					break out;
				}
			}
		}
		System.out.println(result == 0 ? "KAKTUS" : result);
	}
}

class point {
	int x;
	int y;

	public point() {
	}

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}