package Day1011;

import java.util.Scanner;

public class Boj_11034 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		while(sc.hasNext()) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if(b-a < c-b) {
				System.out.println(c-b-1);
			}
			else {
				System.out.println(b-a-1);
			}
		}
	}
	
}
