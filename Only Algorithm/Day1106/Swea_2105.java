package Day1106;

import java.util.Scanner;

public class Swea_2105 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			n = sc.nextInt();
			a = new int[n][n];
			result = -1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int ny,nx;
			boolean visit[][] = new boolean[n][n];
			boolean dessert[] = new boolean[250];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dfs(j,i,0,j,i,visit,dessert);
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	static int a[][];
	static int dx[] = {1,-1,-1,1};
	static int dy[] = {1,1,-1,-1};
	static int n;
	static int result, sum;
	static void dfs(int x,int y,int dir,int sx,int sy,boolean[][] visit,boolean[] dessert) {
		if(dir==4) {
			return;
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(ny<0 || nx<0 || ny>=n || nx>=n) { //가려는 곳을 벗어났어?
			return; // 그럼 안녕
		}
		if(visit[ny][nx]) { // 왔던 곳이라고?
			return; // 그럼 안녕
		}
		if(dessert[a[ny][nx]]) { // 먹었던 디저트라고?
			return; // 그럼 안녕
		}
		visit[ny][nx]=true;
		dessert[a[ny][nx]] = true;
		dfs(nx,ny,dir,sx,sy,visit,dessert); //그대로 쭉 가봐
		
		if(nx == sx && ny == sy) { // 도착 했니?
			sum = 0;
			for(int i=0;i<dessert.length;i++) { // 뭐 먹었니
				if(dessert[i]) {
					sum ++; // 몇 개니?
				}
			}
			if(sum > result) { // 제일 많이 먹은거니?
				result = sum;
			}
			visit[ny][nx]=false;
			dessert[a[ny][nx]] = false;
			return; //끝!
		}
		dfs(nx,ny,dir+1,sx,sy,visit,dessert); // 방향틀어봐
		visit[ny][nx]=false;
		dessert[a[ny][nx]] = false;
	}
}
