package Day1129;

import java.util.Scanner;

public class Boj_5582 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	String a = sc.next();
	String b = sc.next();
	int result = 0;
	for(int i=0;i<a.length();i++) {
		for(int j=0;j<b.length();j++) {
			if(a.charAt(i)==b.charAt(j)) {
				int k = 0;
				int length = 0;
				while(j+k < b.length() && i+k <a.length() && a.charAt(i+k) == b.charAt(j+k)) {
					k++;
					length++;
					if(result < length) {
						result = length;
					}
				}
			}
		}
	}
	System.out.println(result);
}
}
