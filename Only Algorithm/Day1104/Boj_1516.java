package Day1104;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1516 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		building[] b = new building[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			b[i] = new building();
			b[i].time = Integer.parseInt(st.nextToken());
			int k;
			while ((k = (Integer.parseInt(st.nextToken()))) != -1) {
				b[i].pre.add(k - 1);
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int get : b[i].pre) {
//				System.out.print(get+" ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < n; i++) {
			if (b[i].pre.size() == 0 && b[i].totaltime == -1) { // 앞에 할 것이 더 없으면
				int max = 0;
				for (int endnum : b[i].end) { // 전에 했던 것 중 가장 오래 걸리는 것
					if (max < b[endnum].totaltime) {
						max = b[endnum].totaltime;
					}
				}
				b[i].totaltime = max + b[i].time; // 이 건물이 지어지는 시간
				for (int j = 0; j < n; j++) {
					for (int prenum : b[j].pre) {// 모든 건물을 돌면서 이 건물을 해금한다.
						if (prenum == i) {
							b[j].pre.remove(prenum);
							b[j].end.add(prenum);
							break;
						}
					}
				}
				i = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			bw.write(b[i].totaltime + "\n");
		}
		bw.flush();
		bw.close();
	}
}

class building {
	Set<Integer> pre;
	Set<Integer> end;
	int time;
	int totaltime;

	public building() {
		pre = new HashSet<Integer>();
		end = new HashSet<Integer>();
		totaltime = -1;
	}

	public building(Set<Integer> pre, Set<Integer> end) {
		this.pre = pre;
		this.end = end;
		totaltime = -1;
	}

	public building(Set<Integer> pre, Set<Integer> end, int time) {
		this.pre = pre;
		this.end = end;
		this.time = time;
		totaltime = -1;
	}

	public building(Set<Integer> pre, Set<Integer> end, int time, int totaltime) {
		this.pre = pre;
		this.end = end;
		this.time = time;
		this.totaltime = totaltime;
	}
}