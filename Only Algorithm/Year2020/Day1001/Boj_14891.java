package Day1001;

import java.util.Scanner;

public class Boj_14891 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t[] = new String[4];
		for (int i = 0; i < 4; i++) {
			t[i] = sc.next();
		}
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt() - 1;
			int dir = sc.nextInt();
			boolean visit[] = new boolean[4];
			select(num, t, visit, dir);
		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (t[i].charAt(0) == '1')
				result += 1 << i;
		}
		System.out.println(result);
	}

	static int[] lr = { -1, 1 };

	static void select(int sel, String[] t, boolean[] visit, int dir) {
		visit[sel] = true;
		for (int i = 0; i < 2; i++) {
			int nsel = sel + lr[i];
			if (nsel < 0 || nsel >= 4) {
				continue;
			}
			if (visit[nsel]) {
				continue;
			}
			if (i == 0) {
				if (t[sel].charAt(6) == t[nsel].charAt(2)) {
					continue;
				}
			}
			if (i == 1) {
				if (t[sel].charAt(2) == t[nsel].charAt(6)) {
					continue;
				}
			}
			select(nsel, t, visit, -dir);
		}
		t[sel] = turn(t[sel], dir);
	}

	static String turn(String s, int dir) {
		if (dir == -1) { // 반시계
			String fs = s.substring(0, 1);
			String bs = s.substring(1);
			s = bs + fs;
		} else {
			String fs = s.substring(0, 7);
			String bs = s.substring(7);
			s = bs + fs;
		}
		return s;
	}
}
