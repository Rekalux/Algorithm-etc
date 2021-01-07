package Day1031;

import java.util.Scanner;

public class Boj_2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean a[] = new boolean[n + 1];
		int erasecount = 0;
		int save = 0;
		int erasenum = 0;
		while (true) {
			for (int i = 2; i < n + 1; i++) {
				if(a[i]) {
					continue;
				}
				save = i;
				break;
			}
			for(int i = 1; i * save < n+1; i++) {
				if(a[i*save]) {
					continue;
				}
				else {
					erasecount++;
					erasenum = i *save;
					a[i * save] = true;
				}
				if(erasecount == k) {
					break;
				}
			}
			if(erasecount == k) {
				break;
			}
		}
		System.out.println(erasenum);
	}
}
