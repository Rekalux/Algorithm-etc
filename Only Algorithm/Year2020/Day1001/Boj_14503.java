package Day1001;

import java.util.Scanner;

public class Boj_14503 {
	static int X, Y;
	static int map[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		int sy = sc.nextInt();
		int sx = sc.nextInt();
		int dir = sc.nextInt();
		map = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int nx, ny, ndir;
		out: while (true) {
			// System.out.println(sy+" "+sx);
			map[sy][sx] = 2;
			for (int i = 0; i < 4; i++) {
				dir = (dir - 1) == -1 ? 3 : dir - 1;
				nx = sx + dx[dir];
				ny = sy + dy[dir];
				if (map[ny][nx] == 0) {
					sx = nx;
					sy = ny;
					continue out;
				}
			}
			ndir = (dir - 2) < 0 ? dir + 2 : dir - 2;
			nx = sx + dx[ndir];
			ny = sy + dy[ndir];
			if (map[ny][nx] == 1)
				break;
			sx = nx;
			sy = ny;

		}
		int result = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (map[i][j] == 2) {
					result++;
				}
				// System.out.print(map[i][j]+" ");
			}
			// System.out.println();
		}
		System.out.println(result);
	}
}
