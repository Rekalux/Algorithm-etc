package Day0923;

import java.util.Scanner;

public class Boj_14728 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int C[][] = new int[N+1][T+1];
		for(int i=1;i<=N;i++) {
			int t = sc.nextInt();
			int s = sc.nextInt();
			for(int j=1;j<=T;j++) {
				int ad = 0;
				if(j-t>=0) ad = C[i-1][j-t]+s;
				C[i][j] = Math.max(C[i-1][j], ad);
			}
		}
		System.out.println(C[N][T]);
	}

}
