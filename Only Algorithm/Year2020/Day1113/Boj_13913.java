package Day1113;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj_13913 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		int[] visit = new int[100001];
		int[] previsit = new int[100001];
		Arrays.fill(previsit, -1);
		if(a==b) {
			System.out.println(0);
			System.out.println(a);
			return;
		}
		Stack<Integer> resultlist = new Stack<Integer>();
		visit[a] = 1;
		while(!q.isEmpty()) {
			int g = q.poll();
			if(g==b) {
				while(g!=-1) {
					resultlist.add(g);
					g = previsit[g];
				}
				break;
			}
			for(int i=0;i<3;i++) {
				int nn;
				if(i==0) {
					nn = g - 1;
				}
				else if(i==1) {
					nn = g + 1;
				}
				else {
					nn = g * 2;
				}
				if(nn<0 || nn>100000) {
					continue;
				}
				if(visit[nn]>0) {
					continue;
				}
				visit[nn] = visit[g]+1;
				previsit[nn] = g;
				q.add(nn);
			}
		}
		System.out.println(visit[b]-1);
		while(!resultlist.isEmpty()) {
			System.out.print(resultlist.pop()+" ");
		}
	}
}