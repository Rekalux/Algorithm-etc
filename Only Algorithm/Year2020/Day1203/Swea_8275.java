package Day1203;

import java.util.Scanner;

public class Swea_8275 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			n = sc.nextInt();
			x = sc.nextInt();
			m = sc.nextInt();
			int menu[][] = new int[m][3];
			for(int i=0;i<m;i++) {
				menu[i][0] = sc.nextInt()-1;
				menu[i][1] = sc.nextInt()-1;
				menu[i][2] = sc.nextInt();
			}
			int hamster[] = new int[6];
			result = 0;
			resultarray = new int[6];
			allfind=false;
			dfs(hamster,menu,0);
			if(!allfind) {
				System.out.println("#"+tc+" "+-1);
				continue;
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<n;i++) {
				System.out.print(resultarray[i]+" ");
			}
			System.out.println();
		}
	}
	static int n,x,m;
	static int result,resultarray[];
	static boolean allfind;
	static void dfs(int[] hamster,int[][] menu,int idx) {
		boolean find = true;
		out :for(int i=0;i<m;i++) { // 조건을 각각 돌며
			int jogunhap = 0;
			for(int j = menu[i][0] ; j <= menu[i][1] ; j++) {
				jogunhap += hamster[j];
			}
			if(jogunhap==menu[i][2]) {
				continue;
			}
			else {
				find = false;
				break out;
			}
		}
		if(find) {
			int allhap = 0;
			for(int i=0;i<n;i++) {
				allhap += hamster[i];
			}
			if(allhap >= result) {
				result = allhap;
				for(int i=0;i<n;i++) {
					resultarray[i] = hamster[i];
				}
				allfind=true;
			}
		}
		if(idx>=n) { // 인덱스가 선을 넘었다.
			return;
		}
		// 이번 우리의 햄스터가 1늘었다.
		if(hamster[idx]+1<=x) {
			hamster[idx]++;
			dfs(hamster,menu,idx);
			hamster[idx]--;			
		}
		// 다음 우리의 햄스터를 변화하겠다. (인덱스 이동)
		idx++;
		dfs(hamster,menu,idx);
	}
}
