package Day1018;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_12851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int obj = sc.nextInt();
		int a[] = new int[100001]; // 참조? -1 초기화
		Arrays.fill(a, -1); // [-1,-1,-1,-1,-1,...]
		findbro f = new findbro(); // [0,0]
		f.number = start; // [5,0]
		Queue<findbro> q = new LinkedList<findbro>();// Queue, 현재값 + 층
		q.add(f); // [[5,0]]
		int nn = 0;
		findbro fb;
		int save = 100001, count = 0;
		while (!q.isEmpty()) {
			f = q.poll();
			if(f.number == obj) {
				save = f.floor;
				count++;
				continue;
			}
			if(f.floor > save) {
				break;
			}
			a[f.number] = f.floor;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					nn = f.number - 1;
				} else if (i == 1) {
					nn = f.number + 1;
				} else {
					nn = f.number * 2;
				}
				if (nn < 0 || nn > 100000) {
					continue;
				}
				if (a[nn] > -1) {
					continue;
				}
				fb = new findbro();
				fb.number = nn;
				fb.floor = f.floor + 1;
				q.add(fb);
			}
		}
		System.out.println(save);
		System.out.println(count);
	}
}

class findbro {
	int number;
	int floor;
}
