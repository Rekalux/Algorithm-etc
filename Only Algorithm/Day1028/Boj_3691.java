package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Boj_3691 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	Scanner sc =new Scanner(System.in);
	int T = sc.nextInt();
	for(int tc = 0; tc<T;tc++) {
		int num = sc.nextInt();
		int money = sc.nextInt();
		HashMap<String, List<int[]>> map = new HashMap<String, List<int[]>>();
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			st.nextToken();
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			if(map.get(s1)==null) {
				
			}else {
				
			}
		}
		
	}
	
}
}
