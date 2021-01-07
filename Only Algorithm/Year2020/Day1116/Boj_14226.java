package Day1116;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_14226 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //입력받음
		int n = sc.nextInt(); // 숫자가 들어오죠?
		if (n == 1) {
			System.out.println(0); // 바로 0 출력
			return;
		}
		Queue<int[]> q = new LinkedList<int[]>(); // 큐 선언
		int temp[] = new int[3]; // 배열
		temp[0] = 1; // 현재 값
		temp[1] = 0; // 저장한 수
		temp[2] = 0; // 동작 시간
		q.add(temp); // 큐에 삽입
		// 방문체크 1. 현재값 2. 저장한수
		// 현재 값이 같은데 저장한 수가 다른 경우가 있음
		// 6 -> 2 > 4 > 6 저장된 수 : 2
		// 6 -> 2 > 4 > 8 > 6 저장된 수 : 4
		// 6 > 8 혹은 6 > 10
		boolean visit[][] = new boolean[1025][1025];
		// 1024보다 더 큰 수를 깍아 내리는 건 1024에서 내려가는 것보다 느리다. (어림잡음)
		// 2 > 4> 8 > 16 > 32 > 64 > .. > 1024 > -24 > 1000 (이게 1000으로 가는 최소경로라고 가정했기 때문에 1024까지 수용)
		visit[1][0] = true;
		int result = 0; // 결과값을 0으로 저장 (미리 선언 -> 0이면 결과값 아직 못 찾은 경우)
		while (!q.isEmpty()) { // 여기서부터 BFS
			if (result > 0) { // 값을 찾은 경우
				break;
			}
			int get[] = q.poll(); // 받아와서
			for (int i = 0; i < 3; i++) {
				if (i == 0) { // 저장할거야
					if (visit[get[0]][get[0]]) { // 저장할 값에 현재값이 이미 저장되어 있으면 끝.
						continue;
					}
					int newarr[] = { get[0], get[0], get[2] + 1 }; // 새로운 값으로 저장
					visit[get[0]][get[0]] = true;
					q.add(newarr);
				} else if (i == 1) { // 빼낼거야
					if (get[0] + get[1] > 1024) { // 새로운 값이 1024보다 크면 버려
						continue;
					}
					if (get[0] + get[1] == n) { // 내가 찾는 값이면?
						result = get[2] + 1;
						break;
					}
					if (visit[get[0] + get[1]][get[1]]) { // 저장할 값에 이미 온 적 있다면 끝.
						continue;
					}
					int newarr[] = { get[0] + get[1], get[1], get[2] + 1 }; // 새로운 값으로 저장
					visit[get[0] + get[1]][get[1]] = true;
					q.add(newarr);
				} else { // 1개만 지울거야
					if (get[0] - 1 < 0) { // 음수는 볼 필요 없어요!
						continue;
					}
					if (get[0] - 1 == n) { // 내가 찾는 값이면?
						result = get[2] + 1;
						break;
					}
					if (visit[get[0] - 1][get[1]]) { // 온 적있나?
						continue;
					}
					int newarr[] = { get[0] - 1, get[1], get[2] + 1 }; // 새로운 값으로 저장
					q.add(newarr);
				}
			}
		}
		System.out.println(result); //결과 출력
	}
}
