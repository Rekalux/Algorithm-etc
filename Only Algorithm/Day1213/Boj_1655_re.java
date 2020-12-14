package Day1213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Boj_1655_re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> rq = new PriorityQueue<Integer>();
		PriorityQueue<reverseint> lq = new PriorityQueue<reverseint>();
		rq.add(20000);
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(rq.peek() < num) { // 오른쪽 수보다 크면 오른쪽에 추가
				rq.add(num);
			}
			else {
				lq.add(new reverseint(num)); // 그 외엔 왼쪽에 추가
			}
			if(lq.size() < rq.size()) { // 오른쪽 사이즈가 더 크면 왼쪽에 추가
				if(lq.size()+1 == rq.size() && i%2==1) {
				}
				else {
					lq.add(new reverseint(rq.poll()));
				}
			}
			else if(lq.size() > rq.size()) {
				rq.add(lq.poll().n);
			}
			bw.write(lq.peek().n+"\n");
		}
		bw.flush();
		bw.close();
	}
	static class reverseint implements Comparable<reverseint>{
		int n;
		
		public reverseint(int n){
			this.n = n;
		}
		
		@Override
		public int compareTo(reverseint o) {
			if(o.n > n) {
				return 1;
			}
			else if(n > o.n) {
				return -1;
			}
			return 0;
		}

		
	}
	}

