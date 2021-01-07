package Day1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_3691 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int T = Integer.parseInt(br.readLine());
	for(int tc = 0; tc<T;tc++) {
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		HashMap<String, List<int[]>> map = new HashMap<String, List<int[]>>();
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			st.nextToken();
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			//System.out.println(s1+" "+s2+" "+s3+" ");
			int ss[] = {s2,s3,0,0}; // 0 : 가격 / 1 : 성능 / 2 : 인덱스 / 3. 선택여부
			if(map.get(s1)==null) {
				List<int[]> list = new ArrayList<int[]>();
				list.add(ss);
				map.put(s1, list);
			}else {
				List<int[]> list = map.get(s1);
				ss[2] = list.size(); // 길이를 인덱스로 사용
				list.add(ss);
				map.put(s1,list);
			}
		}
		int buy = 0;
		for(String s : map.keySet()) { // 각각의 부품에 대해
			int min = Integer.MAX_VALUE; // 가장 싼 걸 찾아서
			int idx = 0;
			for(int[] a : map.get(s)) { // 그 부품의 성능별 가격을 각각 가져와서
				if(min > a[0]) { // 싼것을 찾아서 저장
					min = a[0];
					idx = a[2]; // 인덱스도 저장
				}
			}
			for(int[] a : map.get(s)) {
				if(idx == a[2]) { // 같은 인덱스를 찾아서
					buy += a[0]; // 가격을 저장하고
					a[3] = 1; // 사용중임을 표시
				}
			}
		}
		int result=0;
		while(money>=buy) {
			int min = Integer.MAX_VALUE; // 가장 성능이 낮은 것을 찾아서
			String temp=""; // 그 부품을 저장할 스트링을 만들고
			int minp = 0; // 가격을 저장하기 위한 공간
			int idx = 0; // 인덱스도 저장
			for(String s : map.keySet()) { // 각 부품을 돌며
				for(int[] a : map.get(s)) { // 그 부품의 종류를 돌며
					if(a[3]==1) { // 사용중인 부품만 찾아서
						if(min > a[1]) { // 성능이 구리다면
							min = a[1]; // 성능과
							temp = s; // 그 부품을 저장하고
							minp = a[0]; // 그 부품의 가격도 저장
							idx = a[2]; // 인덱스도 저장
							break;
						}
					}
				}
			}
			int minidx = -1; // 최소가격의 인덱스
			int minprice = Integer.MAX_VALUE; // 찾는 것 중의 최소가격
			for(int[] a : map.get(temp)) { // 그 부품을 업그레이드 하기위해 성능이 더 좋은 것 중에 그 다음으로 싼 부품 찾기
				if( a[1] > min && minprice > a[0] && buy - minp + a[0] <= money) { // 성능이 우수해야함, 그 중 가격이 제일 싸야하고, 살 수 있어야 함
					minidx = a[2]; // 인덱스 저장
					minprice = a[0]; // 가격 저장
				}
			}
			if(minidx == - 1) { // 못 찾았다면 끝.
				result = min; // 그 때의 최소성능을 반환하고 종료
				break;
			}
			for(int[] a : map.get(temp)) { // 그 부품을 돌며
				if(a[2]== minidx) { // 새로운 부품으로 교체
					buy = buy - minp + a[0];
					a[3] = 1; // 사용함으로 표시
				}
				else if(a[2]==idx) { // 기존 부품 제거
					a[3] = 0; // 비사용으로 바꿈
				}
			}
		}
		System.out.println(result);
		
	}
	
}
}
