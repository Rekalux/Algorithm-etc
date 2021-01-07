package Day1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2966 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	String s = br.readLine();
	int a[] = {0,1,2};
	int b[] = {1,0,1,2};
	int c[] = {2,2,0,0,1,1};
	int k;
	int an=0,bn=0,cn=0;
	for(int i=0;i<n;i++) {
		if(s.charAt(i)=='A') {
			k = 0;
		}
		else if(s.charAt(i)=='B') {
			k = 1;
		}
		else {
			k = 2;
		}
		if(a[i%3]==k) {
			an++;
		}
		if(b[i%4]==k) {
			bn++;
		}
		if(c[i%6]==k) {
			cn++;
		}
	}
	int max = an;
	if(max< bn) {
		max = bn;
	}
	if(max < cn) {
		max = cn;
	}
	System.out.println(max);
	if(max == an) {
		System.out.println("Adrian");
	}
	if(max==bn) {
		System.out.println("Bruno");
	}
	if(max==cn) {
		System.out.println("Goran");
	}
}
}
