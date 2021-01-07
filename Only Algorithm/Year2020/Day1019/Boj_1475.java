package Day1019;

import java.util.Scanner;

public class Boj_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] =new int[10];
		while(n>0) {
			a[n % 10]++;
			n /= 10;
		}
		a[6] += a[9];
		if(a[6]%2==0) {
			a[6] /= 2;
		}
		else {
			a[6] = a[6]/2 + 1;
		}
		int max =1;
		for(int i=0;i<9;i++) {
			if(a[i]> max) {
				max = a[i];
			}
		}
		System.out.println(max);
	}
}
