package Day1202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_1744 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		ArrayList<Integer> mlist = new ArrayList<Integer>();
		ArrayList<Integer> plist = new ArrayList<Integer>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (k < 1) {
				mlist.add(k);
			} else if (k > 1) {
				plist.add(k);
			} else {
				result += 1;
			}
		}
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return -1;
				}
				else if(o1 > o2) {
					return 1;
				}
				return 0;
			}
		};
		mlist.sort(c);
		int mnum = mlist.size();
		if(mnum%2==1) {
			result += mlist.get(mnum-1);
			mnum--;
		}
		for(int i=0;i<mnum;i+=2) {
			result += (mlist.get(i)*mlist.get(i+1));
		}
		
		Comparator<Integer> c2 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return -1;
				}
				else if(o1 < o2) {
					return 1;
				}
				return 0;
			}
		};
		plist.sort(c2);
		int pnum = plist.size();
		if(pnum%2==1) {
			result += plist.get(pnum-1);
			pnum--;
		}
		for(int i=0;i<pnum;i+=2) {
			result += (plist.get(i)*plist.get(i+1));
		}
		System.out.println(result);
	}
}
