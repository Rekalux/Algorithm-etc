package Day1023;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1759 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		n = sc.nextInt();
		s = new String[n];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		Arrays.sort(s);
		//입력 끝
		
//	for(int i=0;i<n;i++) {
//		System.out.print(s[i]);
//	}
		String[] save = new String[l];
		// 저장할 배열
		
		find(0, 0, save);
	}
	static int l,n;
	static String[] s;
	static String[] aeiou = {"a","e","i","o","u"};
	
	static void find(int idx,int a,String[] save) { // save 인덱스가 a
		// 재귀적으로 조합을 찾는 함수
		if(a==save.length) { // 길이가 len개 인 배열
			
			int moum = 0;
			int jaum = 0;
			boolean ffind;
			for(int i=0;i<l;i++) {
				ffind = false;
				for(int j=0;j<5;j++) {
					if(save[i].equals(aeiou[j])) {
						ffind = true;
					}
				}
				if(ffind) {
					moum++;
				}
				else {
					jaum++;
				}
			}
			if(jaum < 2 || moum < 1) {
				return;
			}
			for(int i=0;i<l;i++) {
				System.out.print(save[i]);
			}
			System.out.println();
			return;
		}
		if(idx==n) {
			return;
		}
		save[a] = s[idx];
		find(idx+1,a+1,save);
		find(idx+1,a,save);
	}
}
