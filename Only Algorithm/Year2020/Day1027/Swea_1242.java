package Day1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1242 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int check[][][] = new int[5][4][5];
		check[2][2][1] = 1;
		check[1][2][2] = 2;
		check[4][1][1] = 3;
		check[1][3][2] = 4;
		check[2][3][1] = 5;
		check[1][1][4] = 6;
		check[3][1][2] = 7;
		check[2][1][3] = 8;
		check[1][1][2] = 9;
		String binary[] = new String[16];
		for (int i = 0; i < 16; i++) {
			binary[i] = "";
			int num = i;
			while (num != 0) {
				binary[i] = (num % 2) + binary[i];
				num /= 2;
			}
			while (binary[i].length() < 4) {
				binary[i] = "0" + binary[i];
			}
			// System.out.println(binary[i]);
		}

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int result = 0;
			int iscode = 0;
			st = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			String map[] = new String[Y];
			for (int i = 0; i < Y; i++) {
				String s = br.readLine();
				String news = "";
				int temp = 0;
				for (int j = 0; j < X; j++) {
					if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
						temp = s.charAt(j) - 'A' + 10;
					} else {
						temp = s.charAt(j) - '0';
					}
					news += binary[temp];
				}
				map[i] = news;
			}
//			for(int i=0;i<Y;i++) {
//				System.out.println(map[i]);
//			}
			for (int i = 0; i < Y; i++) {
				out : for (int j = X * 4 - 1; j >= 0; j--) {
					if (map[i].charAt(j) == '1' && (i == 0 || map[i - 1].charAt(j) == '0')) {
						int[] code = new int[8];
						for (int test = 7; test >= 0; test--) {
							int[] tamsasoo = new int[4];

							while (j >= 0 &&map[i].charAt(j) == '1') {
								tamsasoo[3]++;
								j--;
							}
							while (j >= 0 &&map[i].charAt(j) == '0') {
								tamsasoo[2]++;
								j--;
							}
							while (j >= 0 &&map[i].charAt(j) == '1') {
								tamsasoo[1]++;
								j--;
							}
							while (j >= 0 && map[i].charAt(j) == '0') {
								j--;
							}
							int minnum = min(tamsasoo[1], tamsasoo[2], tamsasoo[3]);
							// System.out.println(minnum);
							if(minnum==0)
								continue out;
							for (int k = 1; k < 4; k++) {
								tamsasoo[k] = tamsasoo[k] / minnum;
							}
							code[test] = check[tamsasoo[1]][tamsasoo[2]][tamsasoo[3]];
						}
						iscode = (code[0] + code[2] + code[4] + code[6]) * 3 + code[1] + code[3] + code[5] + code[7];
						if (iscode % 10 == 0) {
							result += (code[0] + code[2] + code[4] + code[6] + code[1] + code[3] + code[5] + code[7]);
						}
						j++;
					}
				}
			}
			System.out.println(result);
		}
	}

	static int min(int a, int b, int c) {
		if (a <= b && b <= c) {
			return a;
		} else if (c <= b && b <= a) {
			return c;
		} else if (b <= a && a <= c) {
			return b;
		} else if (c <= a && a <= b) {
			return c;
		} else if (a <= c && c <= b) {
			return a;
		} else {
			return b;
		}
	}
}
