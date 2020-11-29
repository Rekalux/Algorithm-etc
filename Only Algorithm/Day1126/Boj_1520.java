package Day1126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1520 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int y = Integer.parseInt(st.nextToken());
	int x = Integer.parseInt(st.nextToken());
	int a[][] = new int[y][x];
	int a2[][] = new int[y][x];
	PriorityQueue<block> q = new PriorityQueue<block>();
	for(int i=0;i<y;i++) {
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<x;j++) {
			int high = Integer.parseInt(st.nextToken());
			q.add(new block(high,j,i));
			a2[i][j] = high;
		}
	}
	a[0][0] = 1;
	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
	while(!q.isEmpty()) {
		block b = q.poll();
		for(int i=0;i<4;i++) {
			int ny = b.y + dy[i];
			int nx = b.x + dx[i];
			if(ny<0 || nx<0 || ny>=y || nx>=x) {
				continue;
			}
			if(a2[ny][nx] <= a2[b.y][b.x]) {
				continue;
			}
			a[b.y][b.x] += a[ny][nx];
		}
	}
	System.out.println(a[y-1][x-1]);
}
	static class block implements Comparable<block>{
		int high;
		int x;
		int y;
		public block() {

		}

		public block(int high, int x,int y) {
			this.high = high;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(block o) {
			if(this.high < o.high) {
				return 1;
			}
			else if(this.high > o.high) {
				return -1;
			}
			return 0;
		}
		
		
	}
}
