package Day1127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1937 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int a[][] = new int[n][n];
		int b[][] = new int[n][n];
		PriorityQueue<panda> q = new PriorityQueue<panda>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
				q.add(new panda(j,i,b[i][j]));
			}
		}
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		int result = 0;
		while(!q.isEmpty()) {
			panda p = q.poll();
			for(int i=0;i<4;i++) {
				int ny = dy[i] + p.y;
				int nx = dx[i] + p.x;
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}
				if(b[p.y][p.x] >= b[ny][nx]) {
					continue;
				}
				if(a[ny][nx] <= a[p.y][p.x]) {
					continue;
				}
				a[p.y][p.x] = a[ny][nx];
			}
			a[p.y][p.x] += 1;
			if(result < a[p.y][p.x]){
				result = a[p.y][p.x];
			}
		}
		System.out.println(result);
	}

	static class panda implements Comparable<panda> {
		int x;
		int y;
		int namu;

		public panda() {
		}

		public panda(int x, int y, int namu) {
			this.x = x;
			this.y = y;
			this.namu = namu;
		}

		@Override
		public int compareTo(panda o) {
			if (this.namu > o.namu) {
				return -1;
			} else if (this.namu < o.namu) {
				return 1;
			}
			return 0;
		}
	}
}
