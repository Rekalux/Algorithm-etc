package Day1129;

import java.util.Scanner;

public class Boj_5582 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	String a = sc.next();
	String b = sc.next();
	int result = 0;
	int dp[][] =new int[a.length()][b.length()];
	for(int i=0;i<a.length();i++) {
		for(int j=0;j<b.length();j++) {
			if(i==0 || j==0) {
				if(a.charAt(i)==b.charAt(j)) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = 0;
				}
				continue;
			}
			dp[i][j] = a.charAt(i)==b.charAt(j) ? (dp[i-1][j-1] + 1) : 0;
			if(dp[i][j] > result) {
				result = dp[i][j];
			}
		}
	}
	System.out.println(result);
}
}
