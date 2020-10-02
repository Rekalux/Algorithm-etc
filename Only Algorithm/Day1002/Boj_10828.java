package Day1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Stack s = new Stack();
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			StringTokenizer st = new StringTokenizer(a);
			String t = st.nextToken();
			if (t.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			} else if (t.equals("top")) {
				bw.write(s.returntop()+"\n");
			} else if (t.equals("size")) {
				bw.write(s.size()+"\n");
			} else if (t.equals("empty")) {
				bw.write(s.isempty()+"\n");
			} else if (t.equals("pop")) {
				bw.write(s.pop()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}

class Stack {
	int top;
	int a[];

	Stack() {
		top = 0;
		a = new int[10001];
	}

	int size() {
		return top;
	}

	void push(int n) {
		a[top++] = n;
	}

	int isempty() {
		return top == 0 ? 1 : 0;
	}

	int returntop() {
		return top == 0 ? -1 : a[top - 1];
	}

	int pop() {
		return top == 0 ? -1 : a[--top];
	}
}