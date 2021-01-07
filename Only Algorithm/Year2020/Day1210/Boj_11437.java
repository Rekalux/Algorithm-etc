package Day1210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Boj_11437 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //15개의 
		list = new LinkedList[n+1];
		for(int i=0;i<n+1;i++) {
			list[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<n-1;i++) { //14개의 간선
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			list[left].add(right);
			list[right].add(left);
		}
		mother = new int[n+1];
		mother[1] = -1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		while(!stack.isEmpty()) {
			int get = stack.pop();
			for(int next : list[get]) {
				if(mother[next]!=0) {
					continue;
				}
				mother[next] = get;
				stack.add(next);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(left);
			int result = 1;
			while(left!=1) {
				left = mother[left];
				set.add(left);
			}
			while(right!=1) {
				if(set.contains(right)) {
					result = right;
					break;
				}
				right = mother[right];
			}
			bw.write(result+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static LinkedList<Integer> list[];
	static int mother[];
}
