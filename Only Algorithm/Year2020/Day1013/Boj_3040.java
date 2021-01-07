package Day1013;

import java.util.Scanner;

public class Boj_3040 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	a = new int[9];
	for(int i=0;i<9;i++) {
		a[i] = sc.nextInt();
	}
	int b[] = new int[7];
	find(0,0,b);
}
static int a[];
static boolean end;
static void find(int s,int idx,int b[]) {
	if(end) {
		return;
	}
	if(idx>6) {
		int sum =0;
		for(int i=0;i<7;i++) {
			sum += b[i];
		}
		if(sum==100) {
			end = true;
			for(int i=0;i<7;i++) {
				System.out.println(b[i]);
			}
		}
		return;
	}
	
	if(s>8) {
		return;
	}
	
	b[idx] = a[s];
	find(s+1,idx+1,b);
	find(s+1,idx,b);
}
}
