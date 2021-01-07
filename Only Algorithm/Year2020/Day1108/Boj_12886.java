package Day1108;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_12886 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int a[] = new int[3];
	for(int i=0;i<3;i++) {
		a[i] = sc.nextInt();
	}
	sort3num(a);
	boolean visit[][][] = new boolean[501][1001][1501];
	Queue<int[]> q = new LinkedList<int[]>();
	q.add(a);
	visit[a[0]][a[1]][a[2]] = true;
	int result = 0;
	if(a[0]==a[1] && a[1] == a[2]) {
		result = 1;
	}
	while(!q.isEmpty()) {
		int[] b = q.poll();
		for(int i=0;i<3;i++) {
			if(b[i]==b[(i+1)%3]) {
				continue;
			}
			int x = Math.min(b[i], b[(i+1)%3]);
			int y = Math.max(b[i], b[(i+1)%3]);
			y -= x;
			x += x;
			int[] c = new int[3];
			c[0] = x;
			c[1] = y;
			c[2] = b[(i+2)%3];
			sort3num(c);
			if(visit[c[0]][c[1]][c[2]]) {
				continue;
			}
			if(c[0]==c[1] && c[1] == c[2]) {
				result = 1;
				q.clear();
				break;
			}
			visit[c[0]][c[1]][c[2]] = true;
			q.add(c);
		}
	}
	System.out.println(result);
}
static void sort3num(int[] a) { // 길이가 3인 정수배열을 버블정렬하는 함수
	if(a[0] > a[1]) {
		a[1] = a[1] ^ a[0] ^ (a[0] = a[1]);
	}
	if(a[1] > a[2]) {
		a[1] = a[1] ^ a[2] ^ (a[2] = a[1]);
	}
	if(a[0] > a[1]) {
		a[1] = a[1] ^ a[0] ^ (a[0] = a[1]);
	}
}
}
