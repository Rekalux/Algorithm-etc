package Day1007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_11723 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
//	add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//	remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//	check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//	toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//	all: S를 {1, 2, ..., 20} 으로 바꾼다.
//	empty: S를 공집합으로 바꾼다. 
	int M = Integer.parseInt(br.readLine());
	StringTokenizer st;
	set s = new set();
	String str;
	for(int i=0;i<M;i++) {
		st = new StringTokenizer(br.readLine());
		str = st.nextToken();
		if(str.equals("add")) {
			s.add(Integer.parseInt(st.nextToken()));
		}else if(str.equals("remove")) {
			s.remove(Integer.parseInt(st.nextToken()));
		}else if(str.equals("check")) {
			bw.write(s.check(Integer.parseInt(st.nextToken()))+"\n");
		}else if(str.equals("toggle")) {
			s.toggle(Integer.parseInt(st.nextToken()));
		}else if(str.equals("all")) {
			s.all();
		}else if(str.equals("empty")) {
			s.empty();
		}
	}
	bw.flush();
	bw.close();
}
}
class set{
	int[] a = new int[21];
	
	public void add(int n) {
		a[n] = 1;
	}
	public void remove(int n) {
		a[n] = 0;
	}
	public int check(int n) {
		return a[n];
	}
	public void toggle(int n) {
		a[n] = 1-a[n];
	}
	public void all() {
		for(int i=1;i<21;i++) {
			a[i] = 1;
		}
	}
	public void empty() {
		for(int i=1;i<21;i++) {
			a[i] = 0;
		}
	}
}