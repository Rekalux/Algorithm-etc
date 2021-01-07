package Day1011;

import java.util.Scanner;

public class Boj_10162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 300;
		int b = 60;
		int c = 10;
		int T = sc.nextInt();
		if(T%c!=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(T/a+" "+(T%a)/b+" "+T%b/c);
	}
	
}
