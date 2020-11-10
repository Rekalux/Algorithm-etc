package Day1111;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1963 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==b) {
				System.out.println(0);
				continue;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			int visit[] = new int[10000];
			visit[a] = 1;
			boolean sosu[] = new boolean[10000];
			for (int i = 1000; i < 10000; i++) {
				for (int j = 2; j <= Math.pow(i, 0.5); j++) {
					if (i % j == 0) {
						sosu[i] = true;
						break;
					}
				}
			}
			q.add(a);
			int result = 0;
			while (!q.isEmpty()) {
				int get = q.poll();
				String s = get + "";
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 10; j++) { // i번째 자리를 j로 바꾸면?
						if (i == 0 && j == 0) {
							continue;
						}
						char[] news = s.toCharArray();
						news[i] = (char) (j + '0');
						int newnum = Integer.parseInt(String.valueOf(news));
						if(sosu[newnum] || visit[newnum]>0) {
							continue;
						}
						visit[newnum] = visit[get]+1;
						if(newnum == b) {
							result = visit[newnum];
						}
						q.add(newnum);
					}
				}
			}
			if(result == 0) {
				System.out.println("Impossible");
			}
			else {
				System.out.println(result-1);
			}
		}
	}
}
