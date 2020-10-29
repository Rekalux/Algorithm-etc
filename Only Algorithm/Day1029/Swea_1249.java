package Day1029;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Swea_1249 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int dx[] = {0,0,-1,1};
	int dy[] = {1,-1,0,0};
	int nx,ny;
	int T = sc.nextInt();
	car result = new car();
	for(int tc=1;tc<T+1;tc++) {
		PriorityQueue<car> q = new PriorityQueue<car>();
		System.out.print("#"+tc+" ");
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			String s = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		boolean visit[][] = new boolean[n][n];
		q.add(new car(0,0,0));
		visit[0][0] = true;
		while(!q.isEmpty()) {
			car c = q.poll();
			if( c.x == n-1 && c.y == n-1) {
				result = c;
				break;
			}
			for(int dir=0;dir<4;dir++) {
				nx = c.x + dx[dir];
				ny = c.y + dy[dir];
				if(nx< 0 || ny<0 || nx >= n || ny>=n) {
					continue;
				}
				if(visit[ny][nx]) {
					continue;
				}
				visit[ny][nx] = true;
				q.add(new car(nx,ny,c.dis+map[ny][nx]));
			}
		}
		System.out.println(result.dis);
	}
}
}
class car implements Comparable<car>{
	int x;
	int y;
	int dis;
	public car() {}
	public car(int x,int y,int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
		
	
	@Override
	public int compareTo(car o) { // 목적값이 더 크면 거리 1
		if(this.dis > o.dis) {
			return 1;
		}
		else if(this.dis < o.dis) {
			return -1;
		}
		else return 0;
	}
}