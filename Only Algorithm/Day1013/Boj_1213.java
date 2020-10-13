package Day1013;

import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Boj_1213 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	int al[] = new int[26];
	for(int i=0;i<s.length();i++) {
		al[s.charAt(i)-'A'] += 1;
	}
	int count = 0;
	int holl = -1;
	for(int i=0;i<26;i++) {
		if(al[i]%2==1) {
			count++;
			holl = i;
			al[i]-=1;
		}
	}
	if(count>1) {
		System.out.println("I'm Sorry Hansoo");
		return;
	}
	String present = "";
	for(int i=0;i<26;i++){
		for(int j=0;j<(al[i]/2);j++) {
			present = present+(char)(i+'A');
		}
		al[i] = al[i]/2;
	}
	if(holl >= 0) {
		present = present+ (char)(holl+'A');
	}
	for(int i=25;i>=0;i--) {
		while(al[i]>0) {
			present = present+(char)(i+'A');
			al[i]--;
		}
	}
	System.out.println(present);
}
}
