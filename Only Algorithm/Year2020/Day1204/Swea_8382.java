package Day1204;

import java.util.Scanner;

public class Swea_8382 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int T = sc.nextInt();
	for(int tc = 1 ;tc <T+1 ;tc++) {
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);
		int maxdis = Math.abs(dx-dy);
		int result = 0;
		if(maxdis % 2 == 1) {
			maxdis--;
			result++;
		}
		result += (maxdis*2);
		result += (Math.min(dx, dy) * 2);
		System.out.println("#"+tc+" "+result);
	}
}
}
