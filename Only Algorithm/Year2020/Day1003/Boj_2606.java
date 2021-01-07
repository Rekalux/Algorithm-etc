package Day1003;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int co[][] = new int[n+1][n+1];
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			co[x][y] = 1;
			co[y][x] = 1;
		}
		a[1] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		int count = 1;
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i=1;i<n+1;i++) {
				if(co[p][i]==1 && a[i]==0) {
					a[i] = count;
					count++;
					q.add(i);
				}
			}
		}
		System.out.println(count-1);
	}
}
