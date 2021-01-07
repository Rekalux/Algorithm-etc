package Day1009;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_7569 {
	static int X, Y, Z;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		Z = sc.nextInt();
		int tomato[][][] = new int[Z][Y][X];
		for (int i = 0; i < Z; i++) {
			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					tomato[i][j][k] = sc.nextInt();
				}
			}
		}

		int dx[] = { 1, -1, 0, 0, 0, 0 };
		int dy[] = { 0, 0, 1, -1, 0, 0 };
		int dz[] = { 0, 0, 0, 0, -1, 1 };

		int nx, ny, nz;

		Queue<to> q = new LinkedList<to>();
		for (int ii = 0; ii < Z; ii++) {
			for (int jj = 0; jj < Y; jj++) {
				for (int kk = 0; kk < X; kk++) {
					if (tomato[ii][jj][kk] == 1) {
						q.add(new to(kk, jj, ii, 0));
					}
				}
			}
		}
		int max = 0;
		while (!q.isEmpty()) {
			to t = q.poll();
			for (int i = 0; i < 6; i++) {
				nx = t.x + dx[i];
				ny = t.y + dy[i];
				nz = t.z + dz[i];

				if (nx >= X || nx < 0 || ny >= Y || ny < 0 || nz >= Z || nz < 0) {
					continue;
				}
				if (tomato[nz][ny][nx] == -1 || tomato[nz][ny][nx] == 1) {
					continue;
				}
				tomato[nz][ny][nx] = 1;
				max = t.day + 1;
				q.add(new to(nx, ny, nz, max));
			}
		}
		int count = 0;
		for (int ii = 0; ii < Z; ii++) {
			for (int jj = 0; jj < Y; jj++) {
				for (int kk = 0; kk < X; kk++) {
					if (tomato[ii][jj][kk] == 0) {
						count++;
					}
				}
			}
		}
		if (count > 0) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}

	}
}

class to {
	int x;
	int y;
	int z;
	int day;

	public to(int x, int y, int z, int day) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}

}
