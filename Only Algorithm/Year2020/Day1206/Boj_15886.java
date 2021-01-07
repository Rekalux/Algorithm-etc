package Day1206;

import java.util.Scanner;

public class Boj_15886 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int count = 0;
		if(s.charAt(0)=='W') {
			count++;
		}
		if(s.charAt(n-1)=='E') {
			count++;
		}
		for(int i=0;i<n-1;i++) {
			if(s.charAt(i)=='E' && s.charAt(i+1)=='W') {
				count++;
			}
		}
		System.out.println(count);
	}
}
