package Day0923;

import java.util.Scanner;

public class Boj_12865 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int K = sc.nextInt();
	int bag[][] = new int[N+1][K+1];
	for(int i=1;i<=N;i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		for(int j=1;j<=K;j++) {
			int ad = 0;
			if(j-a>=0) ad = bag[i-1][j-a]+b;
			bag[i][j] = Math.max(bag[i-1][j], ad);
		}
	}
	System.out.println(bag[N][K]);
}
}
