package Day1002;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj_11866 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		int start = b;
		java.util.Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<n+1;i++) {
			q.add(i);
		}
		System.out.print("<");
		int temp;
		while(!q.isEmpty()) {
			for(int i=0;i<b-1;i++) {
				q.add(q.poll());
			}
			temp = q.poll();
			System.out.print(temp);
			if(q.isEmpty()) {
				break;
			}
			System.out.print(", ");
		}
		System.out.println(">");
	}
}
