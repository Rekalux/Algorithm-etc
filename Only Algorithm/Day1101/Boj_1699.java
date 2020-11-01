package Day1101;

import java.util.Scanner;

public class Boj_1699 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int a[] = new int[n+1];
	int k = 0;
	for(int i=1;i<n+1;i++) {
		int min = 999999;
		for(int j=1;i-(j*j)>=0;j++) {
			k = i-(j*j);
			if(a[k]<min) {
				min = a[k];
			}
		}
		a[i] = min+1;
	}
	System.out.println(a[n]);
}
}
