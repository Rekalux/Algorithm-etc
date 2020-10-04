package Day1004;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_14466 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		int map[][] = new int[N][N];
		boolean cowmap[][] = new boolean[N][N];
		boolean visit[][] = new boolean[N][N];
		int cow[] = new int[R];
		int x1,x2,y1,y2;
		int dx[] = {0,1,0,-1};
		int dy[] = {-1,0,1,0};
		int nx,ny;
		for(int i=0;i<K;i++) {
			y1 = sc.nextInt()-1;
			x1 = sc.nextInt()-1;
			y2 = sc.nextInt()-1;
			x2 = sc.nextInt()-1;
			for(int j=0;j<4;j++){
				nx = x1+dx[j];
				ny = y1+dy[j];
				if(nx<0 || ny<0 || nx>=N || ny>=N) {
					continue;
				}
				if(nx == x2 && ny == y2) {
					map[y1][x1] += (1<<j);
					map[y2][x2] += (1<<((j+2)%4));
					break;
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int i=0;i<R;i++) {
			y1 = sc.nextInt()-1;
			x1 = sc.nextInt()-1;
			cowmap[y1][x1] = true;
		}
		Queue<Point> q = new LinkedList<Point>();
		Point p;
		int count = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(cowmap[i][j] && !visit[i][j]) {
					q.add(new Point(j,i));
					visit[i][j] = true;
					cow[count]++;
					while(!q.isEmpty()) {
						p = q.poll();
						for(int k=0;k<4;k++) {
							nx = p.x +dx[k];
							ny = p.y +dy[k];
							if(nx <0 || ny <0 || nx>=N || ny>=N) {
								continue;
							}
							if(visit[ny][nx]) {
								continue;
							}
							if( ((1 << k) & map[p.y][p.x]) != 0) {
								continue;
							}
							if(cowmap[ny][nx]) {
								cow[count]++;
							}
							visit[ny][nx] = true;
							q.add(new Point(nx,ny));
						}
					}
					count++;
				}
			}
		}
		long result = 0;
		for(int i=0;i<R;i++) {
			result += (cow[i] * (R - cow[i]));
		}
		System.out.println(result/2);
	}
}
