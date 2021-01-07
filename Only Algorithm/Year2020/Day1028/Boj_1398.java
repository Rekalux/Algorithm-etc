package algo;

import java.util.Scanner;

public class Boj_1398 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		Long table[] = new Long[101];
		table[0] = (long)0;
		
		for(int i=1;i<100;i++) {
			Long a=(long)1000000000, b=(long)1000000000, c=(long)1000000000;
			if(i-25>=0) {
				a = (long)(table[i-25]+1);
			}
			if(i-10>=0) {
				b = (long)(table[i-10]+1);
				if(a>b) {
					a = b;
				}
			}
			c = table[i-1]+1;
			if(a > c) {
				a = c;
			}
			table[i] = a;
		}
//		for(int i=0;i<100;i++) {
//			System.out.print(table[i]+" ");
//		}
		for (int tc = 0; tc < T; tc++) {
			Long car = sc.nextLong();
			Long sum = (long) 0;
			while (car > 0) {
				sum += table[(int)(car%100)];
				car /= 100;
			}
			System.out.println(sum);
		}
	}
}
