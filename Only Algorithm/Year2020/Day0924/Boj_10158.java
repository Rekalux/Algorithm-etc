package Day0924;

import java.util.Scanner;

public class Boj_10158 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int w = sc.nextInt();
	int h = sc.nextInt();
	int p = sc.nextInt();
	int q = sc.nextInt();
	int t = sc.nextInt();
	
	System.out.println(res(w,p,t)+" "+res(h,q,t));
}
	static int res(int size,int loc,int t) {
		int len = loc + t; // 현재 위치 + 이동한 위치
		int remain = len % size; // 전체 이동거리에서 벽값을 몇번 움직이고 남았는지!
		if((len/size)%2==0) {
			return remain;
		}else {
			return size-remain;
		}
	}
}
