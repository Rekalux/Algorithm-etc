package Day1011;

import java.util.Scanner;

public class Boj_2810 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	String s = sc.next();
	int L = 0;
	for(int i=0;i<n;i++) {
		if(s.charAt(i)=='L') {
			L++;
		}
	}
	if(L==0) {
		System.out.println(n);
	}
	else {
		System.out.println(n+1-L/2);
	}
}
}
