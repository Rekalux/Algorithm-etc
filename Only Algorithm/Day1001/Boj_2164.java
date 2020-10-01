package Day1001;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 카드 개수
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<n+1;i++) {
			q.add(i);
		}
		int temp;
		while(true) {
			temp = q.poll();
			if(q.isEmpty()) break;
			q.add(q.poll());
		}
		System.out.println(temp);
	}
}
