package Day1125;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Boj_1525 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int a[][] = new int[3][3];
	int b[][] = new int[3][3];
	boolean hhoxy = true;
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			a[i][j] = sc.nextInt();
			if(i==2 && j==2) {}
			else {
				b[i][j] = i * 3 +j +1;				
			}
			if(a[i][j]!=b[i][j]) {
				hhoxy = false;
			}
		}
	}
	if(hhoxy) {
		System.out.println(0);
		return;
	}
	int[] dx = {0,0,-1,1};
	int[] dy = {1,-1,0,0};
	Set<Integer> visit = new HashSet<Integer>();
	// a > b
	Queue<puzzle> q = new LinkedList<puzzle>();
	q.add(new puzzle(a,0));
	int result = -1;
	oout: while(!q.isEmpty()) {
		puzzle p = q.poll();
		int[][] get = p.puz;
		int dis = p.dis;
		int zi=0,zj=0;
		int that = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(get[i][j]==0) {
					zi = i;
					zj = j;
				}
				if(i==2 && j==2) {
					continue;
				}
				that = that*10+get[i][j];
			}
		}
		if(visit.contains(that)) {
			continue;
		}
		visit.add(that);
		for(int dir=0;dir<4;dir++) {
			int ny = dy[dir] + zi;
			int nx = dx[dir] + zj;
			if(nx<0 || ny<0 || nx>=3 || ny>=3) {
				continue;
			}
			int[][] newget = new int[3][3];
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(i==ny && j==nx) {
						newget[i][j] = get[zi][zj];
						continue;
					}
					else if(i==zi && j==zj) {
						newget[i][j] = get[ny][nx];
						continue;
					}
					newget[i][j] = get[i][j];
				}
			}
//			for(int i=0;i<3;i++) {
//				for(int j=0;j<3;j++) {
//					System.out.print(newget[i][j]+" ");
//				}
//				System.out.println();
//			}
			q.add(new puzzle(newget,dis+1));
			boolean hoxy = true;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(b[i][j] != newget[i][j]) {
						hoxy = false;
					}
				}
			}
			if(hoxy) {
				result = dis+1;
				break oout;
			}
		}
	}
	System.out.println(result);
}
static class puzzle{
	int[][] puz;
	int dis;
	public puzzle(int[][] puz,int dis) {
		this.puz = puz;
		this.dis = dis;
	}
}
}