package Day0915;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_13023 {
	static int N, M;
	static ArrayList<Integer> list[];
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int start, end;
		for (int i = 0; i < M; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			list[start].add(end);
			list[end].add(start);
		}
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
			if(result) break;
		}
		if(result) System.out.println(1);
		else System.out.println(0);
		
		
	}

	static boolean result = false;

	public static void dfs(int n, int count) {
		if (count == 5) {
			result = true;
			return;
		}

		for (int i = 0; i < list[n].size(); i++) {
			if (visited[list[n].get(i)]) {
				continue;
			}
			visited[list[n].get(i)] = true;
			dfs(list[n].get(i),count+1);
			visited[list[n].get(i)] = false;
		}

	}

}