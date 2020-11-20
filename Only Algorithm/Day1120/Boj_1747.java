package Day1120;

import java.util.Scanner;

public class Boj_1747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean a[] = new boolean[1003002];
		boolean b[] = new boolean[1003002];
		for(int i=2;i<1003002;i++) {
			if(b[i]) {
				continue; // 합성수는 소수가 아니다.
			}
			a[i] = true;  // 소수이고,
			for(int j=2;j * i<1003002;j++) {
				b[i*j] = true; // 배수는 합성수이다.
			}
		}
		int n = sc.nextInt(); // 타깃넘버
		for(int i=n;true;i++) {
			if(!a[i]) {
				continue;
			}
			String s = ""+i;
			String ns="";
			for(int j=s.length()-1;j>=0;j--) {
				ns += Character.toString(s.charAt(j));
			}
			if(s.equals(ns)) {
				System.out.println(ns);
				break;
			}
		}
		
	}
}
