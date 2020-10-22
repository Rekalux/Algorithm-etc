package Day1022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		//System.out.println(m+" "+k);
		ArrayList<ArrayList<Long>> list = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> inlist = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			inlist.add(Long.parseLong(new StringTokenizer(br.readLine()).nextToken()));
		}
		list.add(inlist);
		ArrayList<Long> newlist;
		long sum;
		while(inlist.size()>1) { //넣은 리스트의 길이가 1이 될 때까지
			newlist = new ArrayList<Long>();
			sum = 0;
			for(int i=0;i<inlist.size();i = i+2) { // 2개씩 읽는다.
				if(i+1 == inlist.size()) { //맨 마지막에 하나만 있으면
					newlist.add(inlist.get(i)); // 맨 마지막값을 그냥 넣는다.
					continue;
				}
				sum = inlist.get(i) + inlist.get(i+1); // 2개의 값을 가져와 합한 값을 넣는다.
				newlist.add(sum);
			}
			list.add(newlist); // 만들어진 리스트를 추가한다.
			inlist = newlist; // 이번에 만들어진 리스트를 원래의 리스트로 교체한다.
		}
//		for(ArrayList<Long> i : list) {
//			for(Long l : i) {
//				System.out.print(l+" ");
//			}
//			System.out.println();
//		}
		int token;
		int idx,idx2;
		Long result;
		Long getnum;
		for(int i=0;i<m+k;i++) {
			st = new StringTokenizer(br.readLine());
			token = Integer.parseInt(st.nextToken());
			if(token==1) { // 수를 바꾼다. (트리구조도 바꾼다.)
				idx = Integer.parseInt(st.nextToken())-1; // 첫번째에서 가져온 인덱스의 자리로
				getnum = Long.parseLong(st.nextToken()); // 지정해준 값으로
				list.get(0).set(idx, getnum); //바꾼다.
				for(int j=1;j<list.size();j++) {
					if( idx % 2 == 0 && idx + 1 == list.get(j-1).size()) { // 짝수인덱스면서 인덱스가 끝이었다면
						idx = idx / 2; // 인덱스를 바꿔주고
						list.get(j).set(idx, list.get(j-1).get(idx*2)); //합없이 그래로 가져옴
						continue;
					}
					idx = idx / 2; // 인덱스를 바꿔주고
					sum = list.get(j-1).get(idx*2) + list.get(j-1).get(idx*2+1);
					list.get(j).set(idx, sum);
				}
			}
			else { // 구간합을 구한다.
				idx = Integer.parseInt(st.nextToken())-1; // start idx를 가져오고
				idx2 = Integer.parseInt(st.nextToken())-1; // end idx를 가져오고
				result = guganhap(idx,idx2,list.size()-1,0,0,(1<<(list.size()-1))-1,list); // 구간합은 어서오고
				//System.out.println();
				bw.write(result+"\n");
			}
//			for(ArrayList<Long> ii : list) {
//				for(Long l : ii) {
//					System.out.print(l+" ");
//				}
//				System.out.println();
//			}
		}
		bw.flush();
		bw.close();
	}
	static long guganhap(int start, int end, int depth, int idx,int front,int back, ArrayList<ArrayList<Long>> list) {
		//System.out.println(start+" "+end+" "+depth+" "+idx+" "+front+" "+back);
		int mid = (front+back)>>1;
		if(start == end) {
			return list.get(0).get(start);
		}
		else if(depth==0) {
			return list.get(0).get(idx); // 찾는 값을 준다.
		}
		else if(start == front && end == back ){ // 내가 원한 구간이면
			return list.get(depth).get(idx);
		}
		else if(end <= mid) { //기준 값 왼쪽이면
			return guganhap(start,end,depth-1,idx*2,front,mid,list); //왼쪽 결과값으로 넘어간다.
		}
		else if(mid < start) { // 기준값 오른쪽이면
			return guganhap(start,end,depth-1,idx*2+1,mid+1,back,list); //오른쪽 결과값으로 넘어간다.
		}else {
			return guganhap(start,mid,depth-1,idx*2,front,mid,list)
					+ guganhap(mid+1,end,depth-1,idx*2+1,mid+1,back,list);
		}
		// 기준을 찾는 식 : (2*idx+1) * (1<<(depth-1)) == 오른쪽 스타트
		// ((2*idx+1) * (1<<(depth-1))) -1 == 왼쪽 엔드
		// (2*idx) * (1<<(depth-1)) == 왼쪽 스타트
		// ((2*idx+1) * ((1<<(depth)))-1 == 오른쪽 엔드
		// 0,1,2,3 (4-->기준 == 2 ^ 2) / 4
	}
}
