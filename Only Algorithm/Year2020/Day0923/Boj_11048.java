package Day0923;

import java.util.Scanner;

public class Boj_11048 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int M = sc.nextInt();
	int map[][] = new int[N][M];
	for(int i=0;i<N;i++) {
		for(int j=0;j<M;j++) {
			map[i][j] = sc.nextInt();
			int a=0,b=0,c=0;
			if(i-1>=0) {
				a = map[i-1][j];
			}
			if(j-1>=0) {
				b = map[i][j-1];
			}
			if(j-1>=0 && i-1>=0) {
				c = map[i-1][j-1];
			}
			map[i][j] += Math.max(a, Math.max(b, c));
		}
	}
	System.out.println(map[N-1][M-1]);
}
}
