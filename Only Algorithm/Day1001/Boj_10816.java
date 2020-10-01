package Day1001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10816 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int N = 10000000;
		int[] c = new int[20000001];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		for(int i=0;i<n;i++) {
			c[Integer.parseInt(st.nextToken())+N]++;
		}
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
		st = new StringTokenizer(s," ");
		for(int i=0;i<n;i++) {
			bw.append(c[Integer.parseInt(st.nextToken())+N]+" ");
		}
		bw.flush();
		bw.close();
	}
}
