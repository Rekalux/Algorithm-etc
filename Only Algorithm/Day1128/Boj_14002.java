package Day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_14002{
public static void main(String[] args) throws IOException {
	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(br.readLine());
	 StringTokenizer st =new StringTokenizer(br.readLine());
	 int a[] = new int[n]; // 받아온 배열
	 int b[] = new int[n]; // 길이 배열
	 int length = 0;
	 for(int i=0;i<n;i++) {
		 a[i] = Integer.parseInt(st.nextToken());
		 for(int j=i-1;j>=0;j--) {
			 if(a[i] > a[j] && b[i] < b[j]) {
				 b[i] = b[j];
			 }
		 }
		 b[i]++;
		 if(b[i]>length) {
			 length = b[i];
		 }
	 }
	 System.out.println(length);
	 int temp = Integer.MAX_VALUE;
	 Stack<Integer> s = new Stack<Integer>();
	 for(int i=n-1;i>=0;i--) {
		 if(length == b[i] && temp > a[i]) {
			 s.add(a[i]);
			 length--;
			 temp = a[i];
		 }
	 }
	 while(!s.isEmpty()) {
		 System.out.print(s.pop()+" ");
	 }
}
}
