package Day1011;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_9440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			n = sc.nextInt();
			if(n==0) {
				break;
			}
			int a[] = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			int x_i=-1,y_i=0-1;
			int x[] = new int[n];
			int y[] = new int[n];
			for(int i=0;i<n;i++) {
				if(a[i]==0) {
					continue;
				}
				if(x_i==-1) {
					x_i = i;
					x[0]=a[i];
					continue;
				}
				else {
					y_i = i;
					y[0] = a[i];
					break;
				}
			}
			int x_idx=1, y_idx=1;
			for(int i=0;i<n;i++) {
				if(i == x_i || i == y_i) {
					continue;
				}
				if(x_idx>y_idx) {
					y[y_idx] = a[i];
					y_idx++;
				}
				else {
					x[x_idx] = a[i];
					x_idx++;
				}
			}
			int xn=0,yn=0;
			for(int i=0;i<x_idx;i++) {
				xn *= 10;
				xn += x[i];
			}
			for(int i=0;i<y_idx;i++) {
				yn *= 10;
				yn += y[i];
			}
			System.out.println(xn+yn);
		}
	}
}
