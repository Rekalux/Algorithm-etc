package Day1005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj_10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		int n;
		int sum = 0;
		for(int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			if(n==0) {
				sum -= s.pop();
			}
			else {
				s.add(n);
				sum += n;
			}
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}
}
