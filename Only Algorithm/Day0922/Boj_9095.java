package Day0922;

import java.util.Scanner;

public class Boj_9095 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	int num[] =new int[12];
	num[1] = 1;
	num[2] = 2;
	num[3] = 4;
	for(int tc=0;tc<T;tc++) {
		int n = sc.nextInt();
		int result = dp(n,num);
		System.out.println(result);
	}
}
static int dp(int n,int[] num) {
	if(num[n]!=0) {
		return num[n];
	}
	if(n<1) {
		return 0;
	}
	return dp(n-3,num)+dp(n-2,num)+dp(n-1,num);
}
}
