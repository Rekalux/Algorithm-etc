package Day0927;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n[] = new int[num];
		int m[] = new int[num];
		for(int i=0;i<num;i++) {
			n[i] = sc.nextInt();
			m[i] = n[i];
		}
		Arrays.sort(m);
		int a[][] = new int [num+1][num+1];
		for(int i=1;i<num+1;i++) {
			a[0][i] = n[i-1];
			a[i][0] = m[i-1];
		}
		for(int i=1;i<num+1;i++) {
			for(int j=1;j<num+1;j++) {
				int x=0,y=0,z=0;
				if(a[i][0] == a[0][j]) {
					x = 1;
				}
				else {
					x = 0;
				}
				if(j-1>0) {
					y = a[i][j-1];
				}
				else {
					y=0;
				}
				if(i-1>0) {
					z = a[i-1][j];
				}
				else {
					z = 0;
				}
				a[i][j] = Math.max(x+y, z);
			}
		}
//		for(int i=0;i<num+1;i++) {
//			for(int j=0;j<num+1;j++) {
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(num - a[num][num]);
	}
}
