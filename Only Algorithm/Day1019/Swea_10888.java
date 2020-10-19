package Day1019;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_10888 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			list = new ArrayList<Point>();
			length = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j]>1) {
						list.add(new Point(j,i));
						length++;
					}
				}
			}
			int[][] a = new int[list.size()][2];
			min=Integer.MAX_VALUE;
			find(0,0,a);
			System.out.println("#"+tc+" "+min);
		}
	}
	static int length;
	static int n;
	static int min;
	static int map[][];
	static ArrayList<Point> list;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static void find(int s,int a,int al[][]) {
		if(a<1 && s>=length) {
			return;
		}
		if(s>=length) {
			int sum = 0;
			Queue<god> q = new LinkedList<god>();
			boolean[][] visit = new boolean[n][n];
			//System.out.println(al[0][0]+" "+al[0][1]);
			for(int i=0;i<a;i++) {
				q.add(new god(new Point(al[i][1],al[i][0]),0));
				sum += map[al[i][0]][al[i][1]];
				visit[al[i][0]][al[i][1]] = true;
			}
			god p;
			int ny,nx;
			while(!q.isEmpty()) {
				p = q.poll();
//				if(a==2) {
//					System.out.println(p.p.x+" "+p.p.y+" "+sum);
//				}
				for(int i=0;i<4;i++) {
					nx = p.p.x + dx[i];
					ny = p.p.y + dy[i];
					if(nx<0 || ny<0 || nx>=n || ny>= n) {
						continue;
					}
					if(visit[ny][nx]) {
						continue;
					}
					visit[ny][nx] = true;
					if(map[ny][nx]==1) {
						sum += p.dis+1;
					}
					q.add(new god(new Point(nx,ny),p.dis+1));
				}
			}
			if(sum < min) {
				min = sum;
			}
			
			return;
		}
		
		al[a][1] = list.get(s).x;
		al[a][0] = list.get(s).y;
		//System.out.println(al[a][1]+" "+al[a][0]);
		find(s+1,a+1,al);
		find(s+1,a,al);
	}
}
class god{
	Point p;
	int dis;
	public god(Point p,int dis) {
		this.p = new Point();
		this.p.x = p.x;
		this.p.y = p.y;
		this.dis = dis;
	}
}