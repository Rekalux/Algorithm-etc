package Day0924;

import java.util.Scanner;

public class Boj_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int dp[][] = new int[k+1][n+1];
		for(int i=0;i<n+1;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<k+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(j==0) {
					dp[i][j]=1;
				}
				else {
					dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
				}
			}
		}
		System.out.println(dp[k][n]);
	}
}
