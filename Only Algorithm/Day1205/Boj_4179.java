package Day1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		boolean visit[][] = new boolean[y][x];
		Queue<fire> q = new LinkedList<fire>();
		fire start = new fire();
		for (int i = 0; i < y; i++) {
			String s = br.readLine();
			for (int j = 0; j < x; j++) {
				if (s.charAt(j) == 'J') {
					start.y = i;
					start.x = j;
					start.dis = 0;
					start.start = true;
				} else if (s.charAt(j) == 'F') {
					q.add(new fire(i, j, 0));
				}
				if (s.charAt(j) != '.') {
					visit[i][j] = true;
				}
			}
		}
		q.add(start);
		int result = 0;
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		while (!q.isEmpty()) {
			fire f = q.poll();
			if (f.start && (f.y == 0 || f.x == 0 || f.y == y - 1 || f.x == x - 1)) {
				result = f.dis + 1;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int ny = dy[i] + f.y;
				int nx = dx[i] + f.x;
				if (ny < 0 || ny >= y || nx < 0 || nx >= x) {
					continue;
				}
				if(visit[ny][nx]) {
					continue;
				}
				visit[ny][nx] = true;
				q.add(new fire(ny,nx,f.dis+1,f.start));
			}
		}
		System.out.println(result > 0 ? result : "IMPOSSIBLE");
	}

	static class fire {
		int y;
		int x;
		int dis;
		boolean start;

		public fire() {
			this.start = false;
		}

		public fire(int y, int x, int dis) {
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.start = false;
		}
		
		public fire(int y, int x, int dis,boolean start) {
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.start = start;
		}
	}
}
