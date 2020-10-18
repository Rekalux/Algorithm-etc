package Day1018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_16953 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a =sc.nextInt();
		int b= sc.nextInt();
		Queue<dot> q = new LinkedList<dot>();
		dot d = new dot();
		d.x = a;
		d.dis = 0;
		q.add(d);
		dot d2;
		while(!q.isEmpty()) {
			d = q.poll();
			a = d.x;
			if(a*2<=b) {
				a *= 2;
				d2 = new dot();
				d2.x = a;
				d2.dis = d.dis+ 1;
				q.add(d2);
				if(d2.x==b) {
					System.out.println(d2.dis+1);
					return;
				}
			}
			a = d.x;
			if(a<100000000 && a*10+1<=b) {
				a = a*10 +1;
				d2 = new dot();
				d2.x = a;
				d2.dis = d.dis + 1;
				q.add(d2);
				if(d2.x==b) {
					System.out.println(d2.dis+1);
					return;
				}
			}
		}
		System.out.println(-1);
	}
}
class dot{
	int x,dis;
}