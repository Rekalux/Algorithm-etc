package Day1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1112 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n = Integer.parseInt(br.readLine());
	int result[] = new int[n];
	tower t[] = new tower[n];
	
	Stack<tower> s = new Stack<tower>();
	st = new StringTokenizer(br.readLine());
	for(int i=0;i<n;i++) {
		t[i] = new tower();
		t[i].h = Integer.parseInt(st.nextToken());
		t[i].idx = i;
	}
	for(int i=n-1;i>=0;i--) {
		while(!s.isEmpty()) { // 스택이 비어있지 않다면
			if(s.peek().h < t[i].h) { // 스택의 값이 더 작다면
				result[s.pop().idx] = t[i].idx + 1; // 부딪히는 타워를 저장
				continue;
			}
			break;
		}
		tower newt = new tower();
		newt.h = t[i].h;
		newt.idx = t[i].idx;
		s.add(newt);
	}
	for(int i=0;i<n;i++) {
		System.out.print(result[i]+" ");
	}
}
}
class tower{
	int h;
	int idx;
	
}