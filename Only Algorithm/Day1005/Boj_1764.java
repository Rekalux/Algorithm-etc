package Day1005;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		for(int i=0;i<N;i++) {
			set1.add(br.readLine());
		}
		for(int j=0;j<N;j++) {
			s = br.readLine();
			if(set1.contains(s)) {
				set2.add(s);
			}
		}
		int num = set2.size();
		Iterator<String> it = set2.iterator();
		String a[] = new String[num];
		for(int i=0;i<num;i++) {
			a[i] = it.next();
		}
		Arrays.sort(a);
		System.out.println(num);
		for(int i=0;i<num;i++) {
			System.out.println(a[i]);
		}
	}
}
