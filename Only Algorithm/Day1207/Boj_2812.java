package Day1207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		String s = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		boolean element[] = new boolean[n];
		out: for (int i = 0; i < s.length(); i++) {
			if(stack.isEmpty()) {
				stack.add(i);
			}
			else {
				while(!stack.isEmpty()) {
					int a = s.charAt(stack.peek())-'0';
					int b = s.charAt(i)-'0';
					if(a < b) {
						element[stack.pop()] = true;
						count++;
						if(count==k) {
							break out;
						}
						continue;
					}
					break;
				}
				stack.add(i);
			}
		}
		if (count != k) {
			out: for (int i = s.length() - 1; i >= 0; i--) {
				if (!element[i]) {
					element[i] = true;
					count++;
					if (count == k) {
						break out;
					}
				}
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (!element[i]) {
				bw.write(s.charAt(i));
			}
		}
		bw.flush();
	}
}
