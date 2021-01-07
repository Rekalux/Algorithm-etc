package Day1013;

import java.util.Scanner;
import java.util.Vector;

public class Boj_2635 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	Vector<Integer> v,v2 = new Vector<Integer>();
	int a,b;
	int max=0;
	for(int i=1;i<=n;i++) {
		v = new Vector<Integer>();
		v.add(n);
		v.add(i);
		a=n;
		b=i;
		while(a-b>=0) {
			v.add(a-b);
			b = b ^ (a-b) ^ (a=b);
		}
		if(max<v.size()) {
			max = v.size();
			v2 = v;
		}
	}
	System.out.println(max);
	for(int i=0;i<v2.size();i++) {
		System.out.print(v2.get(i)+" ");
	}
}
}
