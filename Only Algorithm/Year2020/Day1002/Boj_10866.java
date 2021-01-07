package Day1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Deck s = new Deck();
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			StringTokenizer st = new StringTokenizer(a);
			String t = st.nextToken();
			if (t.equals("push_front")) {
				s.pushf(Integer.parseInt(st.nextToken()));
			} else if (t.equals("push_back")) {
				s.pushb(Integer.parseInt(st.nextToken()));
			} else if (t.equals("front")) {
				bw.write(s.front() + "\n");
			} else if (t.equals("size")) {
				bw.write(s.size() + "\n");
			} else if (t.equals("empty")) {
				bw.write(s.isempty() + "\n");
			} else if (t.equals("pop_front")) {
				bw.write(s.popf() + "\n");
			} else if (t.equals("pop_back")) {
				bw.write(s.popb() + "\n");
			} else if (t.equals("back")) {
				bw.write(s.back() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}

}

class Deck {
	int top;
	int bottom;
	int a[];

	Deck() {
		top = 10000;
		bottom = 10000;
		a = new int[20001];
	}

	int size() {
		return top - bottom;
	}

	void pushb(int n) {
		a[top++] = n;
	}

	void pushf(int n) {
		a[--bottom] = n;
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

	int popf() {
		return top == bottom ? -1 : a[bottom++];
	}

	int popb() {
		return top == bottom ? -1 : a[--top];
	}

}
