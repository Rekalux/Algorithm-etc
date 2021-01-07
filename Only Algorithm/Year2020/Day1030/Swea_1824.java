package algo;

import java.util.Scanner;
import java.util.Stack;

public class Swea_1824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc + " ");

			int y = sc.nextInt();
			int x = sc.nextInt();
			char[][] map = new char[y][x];
			for (int i = 0; i < y; i++) {
				String s = sc.next();
				for (int j = 0; j < x; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			int dx[] = { 1, 0, -1, 0 }; // 0 : 오른 1: 아래 2: 왼 3: 위
			int dy[] = { 0, 1, 0, -1 };
			Stack<robot> s = new Stack<robot>();
			s.add(new robot(0, 0, 0, 0));
			boolean result = false;
			boolean visit[][][][] = new boolean[y][x][16][4]; // y, x, memory, dir
			
			out: while (!s.isEmpty()) {
				robot r = s.pop();
				visit[r.y][r.x][r.memory][r.dir] = true;
				char put = map[r.y][r.x];
				int ndir = r.dir;
				int nmemory = r.memory;
				if (put == '@') {
					result = true;
					break out;
				} else if (put == '>') {
					ndir = 0;
				} else if (put == '<') {
					ndir = 2;
				} else if (put == '^') {
					ndir = 3;
				} else if (put == 'v') {
					ndir = 1;
				} else if (put == '_') {
					if (r.memory == 0) {
						ndir = 0;
					} else {
						ndir = 2;
					}
				} else if (put == '|') {
					if (r.memory == 0) {
						ndir = 1;
					} else {
						ndir = 3;
					}
				} else if (put == '+') {
					nmemory = (nmemory + 1) % 16;
				} else if (put == '-') {
					nmemory = nmemory - 1 < 0 ? 15 : nmemory-1;
				} else if ('0' <= put && put <= '9') {
					nmemory = put - '0';
				} else if (put == '?') {
					for (int i = 0; i < 4; i++) {
						ndir = i;
						int ny = (r.y + dy[ndir]) % y;
						int nx = (r.x + dx[ndir]) % x;
						if (ny < 0) {
							ny += y;
						}
						if (nx < 0) {
							nx += x;
						}
						if (visit[ny][nx][nmemory][ndir]) {
							continue;
						}
						s.add(new robot(nx, ny, ndir, nmemory));
					}
					continue;
				}
				int ny = (r.y + dy[ndir]) % y;
				int nx = (r.x + dx[ndir]) % x;
				if (ny < 0) {
					ny += y;
				}
				if (nx < 0) {
					nx += x;
				}				
				if (visit[ny][nx][nmemory][ndir]) {
					continue;
				}
				s.add(new robot(nx, ny, ndir, nmemory));
			}
			System.out.println(result ? "YES" : "NO");
		}
	}
}

class robot {
	int x;
	int y;
	int dir;
	int memory;

	public robot() {
	}

	public robot(int x, int y, int dir, int memory) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.memory = memory;
	}
}