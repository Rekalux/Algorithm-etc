package Day0922;

import java.util.Scanner;

public class Boj_9625 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	int[] a = new int[num+1];
	int[] b = new int[num+1];
	a[0] = 1;
	b[0] = 0;
	find(num,a,b);
	System.out.println(a[num]+" "+b[num]);
}
static void find(int num, int a[], int b[]) {
	if(a[num]!=0 || b[num]!=0) {
		return;
	}
	find(num-1,a,b);
	a[num] = b[num-1];
	b[num] = a[num-1]+b[num-1];
}
}
