package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2638 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int map[][] = new int[y + 2][x + 2];
		for (int i = 1; i < y + 1; i++) {
			for (int j = 1; j < x + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		int nx,ny;
		int cnt = 0;
		Queue<point> q = new LinkedList<point>();
		boolean find = false;
		while(true) {
			find = false;
			for(int i=0;i<y+2;i++) {
				for(int j=0;j<x+2;j++) {
					if(map[i][j]!=0) {
						find = true;
					}
				}
			}
			if(find) {
				cnt++;
				q.add(new point(0,0));
				while(!q.isEmpty()) {
					point p = q.poll();
					for(int dir=0;dir<4;dir++) {
						ny = p.y + dy[dir];
						nx = p.x + dx[dir];
						if(nx<0 || ny<0 || nx>=x+2 || ny>=y+2) {
							continue;
						}
						if(map[ny][nx]==0) {
							map[ny][nx]=-1;
							q.add(new point(nx,ny));
						}
						else if(map[ny][nx]>0) {
							map[ny][nx]++;
						}
					}
				}
				for(int i=0;i<y+2;i++) {
					for(int j=0;j<x+2;j++) {
						if(map[i][j]==-1) {
							map[i][j]=0;
						}
						else if(map[i][j]>2) {
							map[i][j] = 0;
						}
						else if(map[i][j]==2) {
							map[i][j] = 1;
						}
					}
				}
			}
			else {
				break;
			}
		}
		System.out.println(cnt);
	}
}

class point {
	int x;
	int y;

	public point() {
	}

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}