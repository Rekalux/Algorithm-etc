package Day0930;

import java.util.Scanner;

public class Boj_14888 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int a[] = new int[n];
	for(int i=0;i<n;i++) {
		a[i] = sc.nextInt();
	}
	int b[] = new int[4];
	for(int i=0;i<4;i++) {
		b[i] = sc.nextInt();
	}
	dfs(1,n,a,b,a[0]);
	System.out.println(max);
	System.out.println(min);
}
static int max = Integer.MIN_VALUE;
static int min = Integer.MAX_VALUE;
static void dfs(int idx,int n,int[]a, int[]b,int result) {
	if(idx==n) {
		if(max < result) {
			max = result;
		}
		if(min > result) {
			min  = result;
		}
		return;
	}
	
	for(int i=0;i<4;i++) {
		if(b[i]<=0) {
			continue;
		}
		b[i] -= 1;
		int result2 = result;
		if(i==0) result2 += a[idx];
		if(i==1) result2 -= a[idx];
		if(i==2) result2 *= a[idx];
		if(i==3) result2 /= a[idx];
		dfs(idx+1,n,a,b,result2);
		b[i] += 1;
	}
}
}
