package Day0924;

import java.util.Scanner;

public class Boj_11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int in[] = new int[num];
		int dp[] = new int[num];
		for(int i=0;i<num;i++) {
			in[i] = sc.nextInt();
			if(i==0) {
				dp[0] = 1;
			}
			else {
				int max=0;
				for(int j=0;j<i;j++) {
					if(in[j]>in[i] && max<dp[j]) {
						max = dp[j];
					}
				}
				dp[i] = max+1;
			}
		}
		int result = 0;
		for(int i=0;i<num;i++) {
			if(result < dp[i]) {
				result = dp[i];
			}
		}
		System.out.println(result);
	}
}
