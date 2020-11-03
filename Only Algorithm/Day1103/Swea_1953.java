package Day1103;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_1953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a[][] = { { 0, 0,0,0}, { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 0 },
				{ 0, 0, 1, 1 }, { 1, 0, 0, 1 } };
		int dx[] = {0,1,0,-1};
		int dy[] = {-1,0,1,0};
		for (int tc = 1; tc < T+1; tc++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int sy = sc.nextInt();
			int sx = sc.nextInt();
			int l = sc.nextInt();
			int map[][] = new int[y][x];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			Queue<man> q = new LinkedList<man>();
			q.add(new man(sx, sy, 1));
			int count = 0;
			boolean visit[][] = new boolean[y][x];
			visit[sy][sx] = true;
			while(!q.isEmpty()) {
				man m = q.poll();
				if(m.dis>l) {
					break;
				}
				count++;
				int pipe = map[m.y][m.x];
				for(int dir=0;dir<4;dir++) {
					if(a[pipe][dir]==0) {
						continue;
					}
					int ny = m.y + dy[dir];
					int nx = m.x + dx[dir];
					if( ny <0 || nx<0 || ny>=y || nx>= x) {
						continue;
					}
					if(visit[ny][nx]) {
						continue;
					}
					if(a[map[ny][nx]][(dir+2)%4] == 0) {
						continue;
					}
					visit[ny][nx] = true;
					q.add(new man(nx,ny,m.dis+1));
				}
			}
			
			System.out.println("#"+tc+" "+count);
			
			
		}

	}
}

class man {
	int x;
	int y;
	int dis;

	public man() {
	}

	public man(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

	@Override
	public String toString() {
		return "man [x=" + x + ", y=" + y + ", dis=" + dis + "]";
	}
}