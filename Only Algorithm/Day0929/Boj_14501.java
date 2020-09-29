package Day0929;

import java.util.Scanner;

public class Boj_14501 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int t[] = new int[n];
	int p[] = new int[n];
	for(int i=0;i<n;i++) {
		t[i] =sc.nextInt();
		p[i] = sc.nextInt();
	}
	int total[] = new int [n];
	for(int i=0;i<n;i++) {
		int max =  0;
		for(int j=0;j<i;j++) {
			if(t[j]+j <= i && max < total[j]) {
				max = total[j];
			}
		}
		total[i] = max + p[i];
	}
	int result =  0;
	for(int i=0;i<n;i++) {
		if(i+t[i] <= n && result < total[i])
			result = total[i];
	}
	System.out.println(result);
}
}
