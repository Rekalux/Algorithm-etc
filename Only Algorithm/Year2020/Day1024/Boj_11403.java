package Day1024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int a[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int m=0; m<n; m++) {
			for(int s=0;s<n;s++) {
				for(int e=0;e<n;e++) {
					if(a[s][e]==0)
					a[s][e] = (a[s][m] & a[m][e]);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				bw.write(a[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
