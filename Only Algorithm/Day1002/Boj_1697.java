package Day1002;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int visit[] = new int[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visit[a] = 1;
		out : while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp == b) {
				break out;
			}
			if(temp-1>0 && visit[temp-1]==0) {
				visit[temp-1] = visit[temp]+1;
				q.add(temp-1);
			}
			if(temp+1<100001 && visit[temp+1]==0) {
				visit[temp+1] = visit[temp]+1;
				q.add(temp+1);
			}
			if(temp*2>0 && temp*2<100001 && visit[temp*2]==0) {
				visit[temp*2] = visit[temp]+1;
				q.add(temp*2);
			}
		}
		System.out.println(visit[b]-1);
	}
}
