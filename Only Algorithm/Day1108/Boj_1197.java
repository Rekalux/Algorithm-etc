package Day1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		node n[] = new node[v];
		for(int i=0;i<n.length;i++) {
			n[i] = new node();
		}
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int gansun = Integer.parseInt(st.nextToken());
			n[start].add(end, gansun);
			n[end].add(start, gansun);
		}
		boolean visit[] = new boolean[v];
		int onedis[] = new int[v];
		Arrays.fill(onedis, Integer.MAX_VALUE);
		visit[0] = true;
		for(line l : n[0].lines) {
			if( l.dis < onedis[l.obj]) {
				onedis[l.obj] = l.dis;
			}
		}
		int result = 0;
		for(int link = 0; link < v-1; link++) {
			int min = Integer.MAX_VALUE;
			int minobj = 0;
			for(int i =0;i<v;i++) {
				if(visit[i] || onedis[i]==Integer.MAX_VALUE) {
					continue;
				}
				if(min > onedis[i]) {
					min = onedis[i];
					minobj = i;					
				}
			}
			visit[minobj] = true;
			result += min;
			
			for(line l : n[minobj].lines) {
				if( l.dis < onedis[l.obj] && !visit[l.obj]) {
					onedis[l.obj] = l.dis;
				}
			}
		}
		System.out.println(result);
		
	}
}
class node{
	ArrayList<line> lines;
	public node(){
		lines = new ArrayList<line>();
	}
	public void add(int obj,int dis) {
		lines.add(new line(obj,dis));
	}
}
class line{
	int obj;
	int dis;
	public line(int obj,int dis) {
		this.obj = obj;
		this.dis = dis;
	}
}