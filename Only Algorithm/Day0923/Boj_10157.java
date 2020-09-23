package Day0923;

import java.util.Scanner;

public class Boj_10157 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int Y = sc.nextInt();
	int X = sc.nextInt();
	int target = sc.nextInt();
	if(X*Y<target) {
		System.out.println(0);
		return;
	}
	int dx[] = {1,0,-1,0};
	int dy[] = {0,1,0,-1};
	int map[][] = new int[Y][X];
	int count = 0;
	int dir = 0;
	int nowx = 0;
	int nowy = 0;
	while(true) {
		count++;
		map[nowy][nowx] = count;
		if(count == target) {
			break;
		}
		int newx = nowx+dx[dir];
		int newy = nowy+dy[dir];
		if(newx <0 || newy <0 || newx >= X || newy >= Y) {
			dir++;
		}
		else if(map[newy][newx]!=0) {
			dir++;
		}
		dir%=4;
		nowx = nowx+dx[dir];
		nowy = nowy+dy[dir];
	}
	System.out.println((nowy+1)+" "+(nowx+1));
}
}
