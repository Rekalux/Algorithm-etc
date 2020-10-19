package Day1019;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_4963 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dx[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
		int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int x, y;
		while (true) {
			x = sc.nextInt();
			y = sc.nextInt();
			if (x == 0 && y == 0) {
				break;
			}
			int map[][] = new int[y][x];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//			for (int i = 0; i < y; i++) {
//				for (int j = 0; j < x; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			int cnt = 0;
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (map[i][j] == 1) {
						Queue<Point> q = new LinkedList<Point>();
						q.add(new Point(j, i));
						map[i][j] = 2;
						while (!q.isEmpty()) { // bfs의 모습
							Point p = q.poll();
							for (int ii = 0; ii < 8; ii++) { // 0. 방향체크
								int nx = p.x + dx[ii];
								int ny = p.y + dy[ii];
								if (ny < 0 || nx < 0 || ny >= y || nx >= x) { // 1. 범위체크
									continue;
								}
								if (map[ny][nx] != 1) { // 2. visit 체크
									continue;
								}
								q.add(new Point(nx,ny)); // 3. q에 추가하면서 visit 변경
								map[ny][nx] = 2;
							}
						}
						cnt ++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
