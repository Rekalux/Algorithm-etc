package Day0929;

import java.util.Scanner;

public class Boj_13458 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	long c[] = new long[n];
	for(int i=0;i<n;i++) {
		c[i]= sc.nextInt();
	}
	long a= sc.nextInt();
	long b = sc.nextInt();
	long result = 0;
	for(int i=0;i<n;i++) {
		c[i] -= a;
	}
	result += n;
	for(int i=0;i<n;i++) {
		if(c[i]<=0) continue;
		long temp = c[i] / b;
		result += temp;
		if(c[i] % b == 0) continue;
		result++;
	}
	System.out.println(result);
}
}
