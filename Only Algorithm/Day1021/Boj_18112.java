package Day1021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_18112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startnum = sc.nextInt();
		int endnum = sc.nextInt();
		int idx = 0;
		int start_int = 0;
		int end_int = 0;
		int sum = 0;
		while (startnum > 0) { // 각 자리의 값을 가져와서 그 가중치만킄 곱하는 반복문.
			sum += (startnum % 10) * (1 << idx);
			idx++;
			startnum /= 10;
		}
		start_int = sum;
		sum = 0;
		idx = 0;
		while (endnum > 0) { // 각 자리의 값을 가져와서 그 가중치만킄 곱하는 반복문.
			sum += (endnum % 10) * (1 << idx);
			idx++;
			endnum /= 10;
		}
		end_int = sum;
		//System.out.println(start_int + " "+ end_int);

		// bfs를 돌려서 바꿀 수 있는 경우를 전부 바꿔서 확인하고 맞으면 정지.
		// bfs를 돌다가 원하는 수를 찾았다. 그럼 종료

		// Queue 에 정수와 거리값을 넣어둔다.
		Queue<bitmaster> q = new LinkedList<bitmaster>(); // [start,0]
		boolean visit[] = new boolean[50000];
		visit[start_int] = true;
		q.add(new bitmaster(start_int, 0));
		int result = 0;
		bitmaster b;
		int newbit;
		while (!q.isEmpty()) {
			b = q.poll();
			if(b.bit == end_int) {
				result = b.dis;
				break;
			}
			for(int i=0;i<2;i++) {
				if(i==0 && b.bit<4999) { // 1을 더해준다.
					newbit = b.bit + 1;
				}else if(i==1 && b.bit>0) { // 0이 아니면 1을 빼준다.
					newbit = b.bit - 1;
				}
				else {
					continue;
				}
				if(visit[newbit]) {
					continue;
				}
				visit[newbit] = true;
				q.add(new bitmaster(newbit,b.dis+1));
			}
			idx = 0;
			while (b.bit >= (1 << idx)) {
				idx++;
			}
			idx--;
			for (int i = idx-1; i >= 0; i--) {
				if ((b.bit & (1 << i)) > 0) { // 그 자리가 1인 경우
					newbit = b.bit - (1 << i);
					}
				else { // 그 자리가 0인 경우
					newbit = b.bit + (1 << i);
				}
				if(newbit<0 && newbit<4999) {
					continue;
				}
				if(visit[newbit]) {
					continue;
				}
				visit[newbit] = true;
				q.add(new bitmaster(newbit,b.dis+1));
			}
			
			
		}
		
		System.out.println(result);

	}
}

class bitmaster {
	int bit;
	int dis;

	public bitmaster() {
		super();
	}

	public bitmaster(int bit, int dis) {
		super();
		this.bit = bit;
		this.dis = dis;
	}
}