package Day1023;

import java.util.Scanner;

public class Boj_9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
//		System.out.println(a);
//		System.out.println(b);
		int[][] dp = new int[a.length()+1][b.length()+1];
		int dx[] = {-1,0,-1};
		int dy[] = {0,-1,-1};
		int ny,nx;
		int max, temp;
		for(int i=0;i<=a.length();i++) {
			for(int j=0;j<=b.length();j++) {
				max = 0;
				for(int k=0;k<3;k++) {
					ny = i+dy[k];
					nx = j+dx[k];
					if(ny < 0 || nx < 0) {
						continue;
					}
					temp = dp[ny][nx];
					if(k == 2 && a.charAt(i-1)==b.charAt(j-1)) {
						temp++;
					}
					if(max < temp) {
						max = temp;
					}
					dp[i][j] = max;
				}
				
			}
		}
		System.out.println(dp[a.length()][b.length()]);
	}
}
