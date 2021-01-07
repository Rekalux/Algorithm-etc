package Day0920;

import java.util.Scanner;

public class Boj_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean paper[][] = new boolean[101][101];
		for(int i=0;i<num;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int yi=y;yi<y+10;yi++) {
				for(int xi=x;xi<x+10;xi++) {
					paper[yi][xi] = true;
				}
			}
		}
		int count = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
