package Day1024;

import java.util.Scanner;

public class Boj_11054 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			int maxcnt = 0;
			for(int j=i-1;j>=0;j--) {
				if(b[j] > maxcnt && a[j] < a[i]) {
					maxcnt = b[j];
				}
			}
			b[i] = maxcnt+1;
		}
		int c[] = new int[n];
		for (int i = n-1; i >= 0 ; i--) {
			int maxcnt = 0;
			for(int j= i+1;j < n;j++) {
				if(c[j] > maxcnt && a[j] < a[i]) {
					maxcnt = c[j];
				}
			}
			c[i] = maxcnt+1;
		}
		int result = 0;
		for(int i=0;i<n;i++) {
			if(result < b[i] + c[i] - 1) {
				result = b[i] + c[i] - 1;
			}
		}
		System.out.println(result);
	}
}
