package Day1002;

import java.util.Scanner;
import java.util.Queue;
import java.awt.Point;
import java.util.LinkedList;

public class Boj_1012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int Y = sc.nextInt();
			int X = sc.nextInt();
			int n = sc.nextInt();
			int map[][] = new int[Y][X];
			int x, y;
			for (int i = 0; i < n; i++) {
				y = sc.nextInt();
				x = sc.nextInt();
				map[y][x] = 1;
			}
			Queue<Point> q = new LinkedList<Point>();
			int dx[] = { 0, 0, -1, 1 };
			int dy[] = { 1, -1, 0, 0 };
			int result = 0;
			int nx, ny;
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (map[i][j] == 1) {
						q.add(new Point(j, i));
						map[i][j] = 0;
						result++;
						while (!q.isEmpty()) {
							Point p = q.poll();
							for (int k = 0; k < 4; k++) {
								ny = p.y + dy[k];
								nx = p.x + dx[k];
								if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
									continue;
								}
								if (map[ny][nx] == 0) {
									continue;
								}
								map[ny][nx] = 0;
								q.add(new Point(nx, ny));
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}
