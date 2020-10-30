package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int cost[] = new int[4];
			for(int i=0;i<4;i++) {
				cost[i] = sc.nextInt();
			}
			int month[] = new int[13];
			for(int i=1;i<13;i++) {
				month[i] = sc.nextInt();
			}
			int monthcost[] = new int[13];
			int sum = 0;
			for(int i=1;i<13;i++) {
				monthcost[i] = month[i] * cost[0];
				if(monthcost[i] > cost[1]) {
					monthcost[i] = cost[1];
				}
			}
			
			int dp[] = new int[12 + 1];
			for (int i = 1; i <= 12; i++) {
				dp[i] = dp[i - 1] + monthcost[i];
				if(i-3 >= 0) {
					if (dp[i] > dp[i - 3] + cost[2]) {
	                    dp[i] = dp[i - 3] + cost[2];
	                }
				}
			}
			System.out.println(Arrays.toString(cost));
			System.out.println(Arrays.toString(monthcost));
			System.out.println(Arrays.toString(dp));
		}
	}
}
