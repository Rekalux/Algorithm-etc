package Day1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue s = new Queue();
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			StringTokenizer st = new StringTokenizer(a);
			String t = st.nextToken();
			if (t.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			} else if (t.equals("front")) {
				bw.write(s.front() + "\n");
			} else if (t.equals("size")) {
				bw.write(s.size() + "\n");
			} else if (t.equals("empty")) {
				bw.write(s.isempty() + "\n");
			} else if (t.equals("pop")) {
				bw.write(s.pop() + "\n");
			} else if (t.equals("back")) {
				bw.write(s.back() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

}

class Queue {
	int top;
	int bottom;
	int a[];

	Queue() {
		top = 0;
		bottom = 0;
		a = new int[10001];
	}

	int size() {
		return top - bottom;
	}

	void push(int n) {
		a[top++] = n;
	}

	int isempty() {
		return top == bottom ? 1 : 0;
	}

	int back() {
		return top == bottom ? -1 : a[top - 1];
	}

	int front() {
		return top == bottom ? -1 : a[bottom];
	}

	int pop() {
		return top == bottom ? -1 : a[bottom++];
	}
}
