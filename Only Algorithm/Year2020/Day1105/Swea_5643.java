package Day1105;

import java.util.Scanner;

public class Swea_5643 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int tc=1;tc<T+1;tc++) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0;i<m;i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt()-1;
			a[start][end] = 1;
		}
		for(int mid=0;mid<n;mid++) {
			for(int start=0;start<n;start++) {
				for(int end=0;end<n;end++) {
					if(start == end) {
						continue;
					}
					a[start][end] = ((a[start][mid] & a[mid][end]) | a[start][end]);
				}
			}
		}
		int sum[] = new int[n];
		int result = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sum[i] += a[i][j];
			}
			for(int j=0;j<n;j++) {
				sum[i] += a[j][i];
			}
			if(sum[i] == n-1) {
				result++;
			}
		}
		System.out.println("#"+tc+" "+result);
	}
}
}
