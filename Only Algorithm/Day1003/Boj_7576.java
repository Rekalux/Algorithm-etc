package Day1003;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_7576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int map[][] = new int[Y][X];
		Queue<Point> q = new LinkedList<Point>();
		int count0 = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					q.add(new Point(j, i));
				}
				if (count0 == 0 && map[i][j] == 0) {
					count0++;
				}
			}
		}
		if (count0 == 0) {
			System.out.println(0);
			return;
		}
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { 1, -1, 0, 0 };
		int nx, ny;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= X || ny >= Y) {
					continue;
				}
				if(map[ny][nx] != 0) {
					continue;
				}
				map[ny][nx] = map[p.y][p.x]+1;
				q.add(new Point(nx,ny));
			}
		}
		int max = 0;
		out : for(int i=0;i<Y;i++) {
			for(int j =0;j<X;j++) {
				if(max < map[i][j]) {
					max = map[i][j];
				}
				if(map[i][j] == 0) {
					max = 0;
					break out;
				}
			}
		}
		System.out.println(max-1);

	}
}
