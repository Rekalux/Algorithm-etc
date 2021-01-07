package Day0923;

import java.util.Scanner;

public class Boj_2579 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int n[] = new int[num];
	int a[] = new int[num]; // 연속
	int b[] = new int[num]; // 최대연속
	for(int i=0;i<num;i++) {
		n[i] = sc.nextInt();
		if(i==0) {
			a[i]=0;
			b[i]=n[i];
		}
		else if(i==1) {
			a[i]=b[i-1]+n[i];
			b[i]=n[i];
		}
		else {
			a[i] = b[i-1]+n[i];
			b[i] = Math.max(a[i-2], b[i-2]) + n[i];
		}
	}
	System.out.println(Math.max(a[num-1], b[num-1]));
	
}
}
