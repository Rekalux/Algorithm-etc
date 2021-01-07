package Day1103;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1194 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		char map[][] = new char[y][x];
		
		Queue<moon> q = new LinkedList<moon>();
		
		for(int i=0;i<y;i++) {
			String s = sc.next();
			for(int j=0;j<x;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					q.add(new moon(j,i));
				}
			}
		}
		
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};

		boolean mapp[][][] = new boolean[y][x][1<<6];
		moon firstmoon = q.peek();
		mapp[firstmoon.y][firstmoon.x][0] = true;
		
		while(!q.isEmpty()) {
			moon m = q.poll();
			//System.out.println(m);
			for(int dir=0;dir<4;dir++) {
				int nx = m.x + dx[dir];
				int ny = m.y + dy[dir];
				if(nx<0 || ny<0 || nx>=x ||ny>=y) {
					continue;
				}
				else if(map[ny][nx]=='#') {
					continue;
				}
				else if(mapp[ny][nx][m.key]) {
					continue;
				}
				else if(map[ny][nx]>='A' && map[ny][nx]<='F') {
					int doornum = map[ny][nx] - 'A';
					if( (m.key & (1<<doornum)) > 0 ) { // 키를 가지고 있는 경우
						mapp[ny][nx][m.key] = true;
						q.add(new moon(nx,ny,m.key,m.dis+1));
					}else { //키가 없는 경우
						continue;
					}
				}
				else if(map[ny][nx]>='a' && map[ny][nx]<='f') {
					int keynum = map[ny][nx] - 'a';
					if( ( m.key & (1 << keynum) ) > 0) { // 키를 가지고 있는 경우
						mapp[ny][nx][m.key] = true;
						q.add(new moon(nx,ny,m.key,m.dis+1));
					}else { //가지고 있지 않은 경우
						int newkey = m.key + (1<<keynum);
						mapp[ny][nx][newkey] = true;
						q.add(new moon(nx,ny,newkey,m.dis+1));
					}
				}
				else if(map[ny][nx] == '1') {
					System.out.println(m.dis+1);
					return;
				}
				else {
					mapp[ny][nx][m.key] = true;
					q.add(new moon(nx,ny,m.key,m.dis+1));
					continue;					
				}
			}
		}
		System.out.println(-1);
		return;
	}
}
class moon{
	int x,y;
	int key;
	int dis;
	public moon() {
		
	}
	public moon(int x,int y) {
		this.x = x;
		this.y = y;
		this.key = 0;
		this.dis = 0;
	}
	public moon(int x,int y,int key,int dis) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.dis = dis;
	}
	@Override
	public String toString() {
		return x+" "+y+" "+key+" "+dis;
	}
}