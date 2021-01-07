package Day1001;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_14502 {
	static int X, Y;
	static int map[][], newmap[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		map = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		for(int i=0;i<Y;i++) {
//			for(int j=0;j<X;j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
		int num[] = new int[3];
		find(0, 0, num);
		System.out.println(result);
	}

	static Queue<Point> q;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int nx, ny;
	static int count, result = 0;

	static void find(int s, int a, int[] num) {
		if (s == 3) {
			newmap = new int[Y][X];
			q = new LinkedList<Point>();
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					newmap[i][j] = map[i][j];
					if (newmap[i][j] == 2) {
						q.add(new Point(j, i));
					}
				}
			}
			for (int i = 0; i < 3; i++) {
				newmap[num[i] / X][num[i] % X] = 1;
			}
			while (!q.isEmpty()) {
				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					nx = p.x + dx[i];
					ny = p.y + dy[i];
					if (ny < 0 || nx < 0 || ny >= Y || nx >= X) {
						continue;
					}
					if (newmap[ny][nx] != 0) {
						continue;
					}
					newmap[ny][nx] = 2;
					q.add(new Point(nx, ny));
				}
			}
			count = 0;
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (newmap[i][j] == 0) {
						count++;
					}
				}
			}
			if (result < count) {
				result = count;
			}
			return;
		}

		if (a == X * Y) {
			return;
		}

		if (map[a / X][a % X] != 0) {
			find(s, a + 1, num);
			return;
		}
		num[s] = a;
		find(s + 1, a + 1, num);
		find(s, a + 1, num);
	}
}
