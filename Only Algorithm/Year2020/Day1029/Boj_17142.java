package Day1029;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Boj_17142 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	map = new int[n][n];
	List<virus> list = new ArrayList<virus>();
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			map[i][j] = sc.nextInt();
			if(map[i][j] == 2) {
				list.add(new virus(j,i,0));
			}
		}
	}
	int select[] = new int[m];
	find(0,0,select,list,m,n);
	System.out.println(result == Integer.MAX_VALUE ? -1 : result);
}
static int map[][];
static int result = Integer.MAX_VALUE;
static int total = 0;
static int dx[] = {0,0,-1,1};
static int dy[] = {1,-1,0,0};
static int nx,ny;
static int test = 0;
static void find(int s,int a,int[] select,List<virus> list,int m,int n) {
	if(a>=m) {
		Queue<virus> q = new LinkedList<virus>();
		boolean visit[][] = new boolean[n][n];
		for(int k : select) {
			q.add(list.get(k));
			visit[q.peek().y][q.peek().x] = true;
		}
		while(!q.isEmpty()) {
			virus v = q.poll();
			for(int i=0;i<4;i++) {
				nx = v.x + dx[i];
				ny = v.y + dy[i];
				if(nx<0 || ny<0 || nx>=n || ny>= n) {
					continue;
				}
				if(visit[ny][nx]) {
					continue;
				}
				if(map[ny][nx]==1) {
					continue;
				}
				if(map[ny][nx]==0) {
					total = v.dis+1;
				}
				visit[ny][nx] = true;
				q.add(new virus(nx,ny,v.dis+1));
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visit[i][j] && map[i][j] == 0) {
					total = Integer.MAX_VALUE;
				}
			}
		}
		if(total < result) {
			result = total;
		}
		return;
	}
	if(s == list.size()) {
		return;
	}
	select[a] = s;
	find(s+1,a+1,select,list,m,n);
	find(s+1,a,select,list,m,n);
}
}
class virus{
	int x;
	int y;
	int dis;
	public virus(int x,int y,int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}