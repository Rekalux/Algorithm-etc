package Day0908;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj_17070 {
	static int N;
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		pipe p = new pipe(0,0,1,0);
		dfs(p);
		System.out.println(result);
		
	}
	
	static int result = 0;
	public static void dfs(pipe p){
		
		int x1 = p.x1;
		int x2 = p.x2;
		int y1 = p.y1;
		int y2 = p.y2;
		
		if(x2 == N-1 && y2== N-1) {
			result++;
			return;
		}
		
		if(y1 == y2) {
			int nx2 = p.x2+1;
			int ny2 = p.y2;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
			nx2 = p.x2+1;
			ny2 = p.y2+1;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0 && map[ny2-1][nx2] == 0 && map[ny2][nx2-1]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
		}
		else if(x1 == x2) {
			int nx2 = p.x2;
			int ny2 = p.y2+1;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
			nx2 = p.x2+1;
			ny2 = p.y2+1;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0 && map[ny2-1][nx2] == 0 && map[ny2][nx2-1]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
		}
		else{
			int nx2 = p.x2;
			int ny2 = p.y2+1;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
			nx2 = p.x2+1;
			ny2 = p.y2;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
			nx2 = p.x2+1;
			ny2 = p.y2+1;
			if(nx2 >= 0 && nx2 <N && ny2 >= 0 && ny2 < N) {
				if(map[ny2][nx2]==0 && map[ny2-1][nx2] == 0 && map[ny2][nx2-1]==0) {
					dfs(new pipe(x2,y2,nx2,ny2));
				}
			}
		}
			
	}
	
}
class pipe{
	int x1,y1,x2,y2;
	public pipe(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
