package Day1106;

import java.util.Scanner;

public class Boj_11049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		point p[] = new point[n];
		for (int i = 0; i < n; i++) {
			p[i] = new point();
			p[i].front = sc.nextInt();
			p[i].end = sc.nextInt();
		}
		int dp[][] = new int[n][n];
		for(int i=1;i<n;i++) {
			int y = 0;
			int x = i; // 시작점
			for(int j=0;j<n-i;j++) { // 변화량
				int ny = y+j;
				int nx = x+j;
				dp[ny][nx] = Math.min(dp[ny+1][nx] + (p[ny].front * p[ny].end * p[nx].end), dp[ny][nx-1] + (p[ny].front * p[nx].front * p[nx].end));
			}
		}
		System.out.println(dp[0][n-1]);
	}
}

class point {
	int front;
	int end;

	public point() {
	}

	public point(int front, int end) {
		this.front = front;
		this.end = end;
	}
}
