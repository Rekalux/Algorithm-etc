package Day0923;

import java.util.Scanner;

public class Boj_1562 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int [][][] dp = new int[101][10][1<<10];
	for(int i=1;i<10;i++) {
		dp[1][i][1<<i] = 1;
	}
	int m = 1000000000;
	//각 자리수별로
	for(int i=2;i<=100;i++) {
		for(int j=0;j<=9;j++) {
			for(int k=0;k<(1<<10);k++) {
				// k | (1<<j)
				if(j==0) {
					dp[i][j][k|1<<j] = (dp[i][j][k|1<<j] + dp[i-1][j+1][k]) % m;
				}
				else if(j==9) {
					dp[i][j][k|1<<j] = (dp[i][j][k|1<<j] + dp[i-1][j-1][k]) % m;
				}else {
					dp[i][j][k|1<<j] = (dp[i][j][k|1<<j] + dp[i-1][j+1][k]) % m;
					dp[i][j][k|1<<j] = (dp[i][j][k|1<<j] + dp[i-1][j-1][k]) % m;
				}
			}
		}
	}
	int ans = 0;
	int N = sc.nextInt();
	for(int i=0;i<10;i++) {
		//1023은 모든 비트가 1. 그것만 생각.
		ans = (ans + dp[N][i][1023]) % m;
	}
	System.out.println(ans);
}
}
