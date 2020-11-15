package Day1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5427 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int T = Integer.parseInt(br.readLine());
	int dx[] = {1,0,0,-1};
	int dy[] = {0,-1,1,0};
	while(T-->0) {
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][m];
		Queue<point> q = new LinkedList<point>();
		point start = new point();
		for(int i=0;i<n;i++) {
			String temp = br.readLine();
			for(int j=0;j<m;j++) {
				if(temp.charAt(j)=='@') {
					start = new point(j,i,0); // 사람은 거리가 0부터 시작
				}
				else if(temp.charAt(j)=='*') {
					q.add(new point(j,i,-1)); // 불은 거리가 -1
				}
				map[i][j] = temp.charAt(j);
			}
		}
		q.add(start);
		int result = 0;
		if(start.x == 0 || start.y ==0 || start.y == n-1 || start.x == m-1) {
			result = 1;
		}
		while(!q.isEmpty()) {
			if(result>0) {
				break;
			}
			point p = q.poll();
			for(int i=0;i<4;i++) {
				int ny = dy[i] + p.y;
				int nx = dx[i] + p.x;
				if(ny<0|| nx<0 || ny>=n || nx>=m) {
					continue;
				}
				if(map[ny][nx] != '.') {
					continue;
				}
				if(p.dis==-1) {
					map[ny][nx] = '*';
					q.add(new point(nx,ny,-1));
					continue;
				}
				if(p.dis>=0 && (ny == 0 || nx ==0 || ny == n-1 || nx == m-1)) { // 인간인데 끝에 있다?
					result = p.dis+2;
					break;
				}
				map[ny][nx] = '@';
				q.add(new point(nx,ny,p.dis+1));
			}
		}
		System.out.println(result>0 ? result : "IMPOSSIBLE");
	}
}
static class point{
	int x;
	int y;
	int dis;
	public point() {
	}
	public point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public point(int x,int y,int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
}
