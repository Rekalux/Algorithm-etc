package Day0920;

import java.util.Scanner;

public class Boj_2669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean map[][] = new boolean[120][120];
		for (int tc = 0; tc < 4; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for(int i=a;i<c;i++) {
				for(int j=b;j<d;j++) {
					map[i][j] = true;
				}
			}
		}
		int count = 0;
		for(int i=0;i<120;i++) {
			for(int j=0;j<120;j++) {
				if(map[i][j]) count++;
			}
		}
		System.out.println(count);
	}
}
