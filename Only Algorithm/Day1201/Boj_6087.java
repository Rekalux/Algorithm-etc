package Day1201;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_6087 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[][] visit = new int[y][x];
		boolean start = false;
		int sx=0,sy=0,ex=0,ey=0;
		for(int i=0;i<y;i++) {
			String s = sc.next();
			for(int j=0;j<x;j++) {
				if(s.charAt(j)=='*') {
					visit[i][j] = -1;
				}
				else if(s.charAt(j)=='C'){
					if(start) {
						ey = i;
						ex = j;
					}
					else {
						sy = i;
						sx = j;
						start = true;
					}
				}
			}
		}
		Queue<Laser> q =new LinkedList<Laser>();
		q.add(new Laser(sx,sy,0,true));
		q.add(new Laser(sx,sy,0,false));
		int dxy[] = {-1,1};
		while(!q.isEmpty()) {
			Laser l = q.poll();
			if(l.y == ey && l.x == ex) {
				System.out.println(l.dis-1);
				break;
			}
			int nextdis = l.dis+1;
			if(l.garo) {
				for(int dir=0;dir<2;dir++) {
					int ny = l.y;
					while(true) {
						ny = ny+dxy[dir];
						if(ny < 0 || ny>=y) {
							break;
						}
						if(visit[ny][l.x]!=0 && visit[ny][l.x]!=nextdis) {
							break;
						}
						visit[ny][l.x] = nextdis;
						q.add(new Laser(l.x,ny,nextdis,false));
					}
				}
			}
			else {
				for(int dir=0;dir<2;dir++) {
					int nx = l.x;
					while(true) {
						nx = nx+dxy[dir];
						if(nx < 0 || nx>=x) {
							break;
						}
						if(visit[l.y][nx]!=0 && visit[l.y][nx]!=nextdis) {
							break;
						}
						visit[l.y][nx] = nextdis;
						q.add(new Laser(nx,l.y,nextdis,true));
					}
				}
			}
		}
	}
	static class Laser{
		int x;
		int y;
		boolean garo;
		int dis;
		public Laser(int x,int y,int dis,boolean garo) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.garo = garo;
		}
	}
}
