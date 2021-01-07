package Day0922;

import java.util.Scanner;

public class Boj_1003 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	c0 = new int[41];
	c1 = new int[41];
	for(int tc=0;tc<T;tc++) {
		int g = sc.nextInt();
		fibonacci(g);
		System.out.println(c0[g]+" "+c1[g]);
	}
}
static int c0[];
static int c1[];
static void fibonacci(int n) {
	if(c0[n]!=0 || c1[n]!=0) {
	}
	else if (n == 0) {
        c0[n] = 1;
    } else if (n == 1) {
        c1[n] = 1;
    } else {
    	fibonacci(n-1);
    	fibonacci(n-2);
    	c0[n] = c0[n-1]+c0[n-2];
    	c1[n] = c1[n-1]+c1[n-2];
    }
}
}
