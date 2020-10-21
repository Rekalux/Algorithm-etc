package Day1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		room a[] = new room[n];
		for(int j=0;j<n;j++) {
			a[j] = new room();
			st = new StringTokenizer(br.readLine());
			a[j].start = Integer.parseInt(st.nextToken());
			a[j].end = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int result = 0;
		int last_end = 0;
		for(int i=0;i<n;i++) {
			if(last_end <= a[i].start) {
				result++;
				last_end = a[i].end;
			}
		}
		System.out.println(result);
	}
}
class room implements Comparable<room>{
	int start;
	int end;
	
	@Override
	public int compareTo(room r) {
		if(this.end > r.end) {
			return 1;
		}else if(this.end < r.end) {
			return -1;
		}else if(this.start > r.start){
			return 1;
		}else if(this.start < r.start) {
			return -1;
		}else {
			return 0;
		}
	}
}