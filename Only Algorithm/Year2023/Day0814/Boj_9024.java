//import java.io.*;
//import java.util.*;
//
//public class Boj_9024 {
//    public static void main(String[] args) throws IOException {
//        // 0. 반복 횟수 입력받고 반복
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            // 1. 변수와 인자 setting
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            problemVariable var = new problemVariable(st);
//            st = new StringTokenizer(br.readLine());
//            var.setIntList(st);
//
//            // 2. 정렬
//            var.sortIntList();
//
//            // 3. 반복 전 초기값 setting
//            var.setLeftAndRight();
//
//            // 4. 반복하며 왼쪽 index 와 오른쪽 index를 옮겨가며 투포인터로 찾음
//            while (var.checkLeftIsSmallerThanRight()) {
//                var.searchAndMoveIndex();
//            }
//
//            // 5. 출력
//            System.out.println(var.getCount());
//        }
//    }
//
//    // 변수 s와 k를 가지는 class
//    private static class problemVariable {
//        private final int s;
//        private final int k;
//        private int left;
//        private int right;
//        private List<Integer> intList = null;
//
//        private int minDiff;
//        private int count;
//
//        public problemVariable(StringTokenizer st) {
//            s = Integer.parseInt(st.nextToken());
//            k = Integer.parseInt(st.nextToken());
//            intList = new ArrayList<>();
//
//            minDiff = Integer.MAX_VALUE;
//            count = 0;
//        }
//
//        private void setIntList(StringTokenizer st) {
//            for (int i = 0; i < s; i++) {
//                intList.add(Integer.parseInt(st.nextToken()));
//            }
//        }
//
//        private void sortIntList() {
//            Collections.sort(intList);
//        }
//
//        private void setLeftAndRight() {
//            left = 0;
//            right = intList.size() - 1;
//        }
//
//        private boolean checkLeftIsSmallerThanRight() {
//            return left < right;
//        }
//
//        private void searchAndMoveIndex() {
//            // 1. 왼쪽값와 오른쪽값의 합을 구함
//            int sum = intList.get(left) + intList.get(right);
//
//            // 2. 합과 k를 비교
//            int diff = Math.abs(k - sum);
//
//            // 3. 최소값이면 count = 1, minDiff 초기화 / 같으면 count += 1
//            if (diff < minDiff) {
//                count = 1;
//                minDiff = diff;
//            } else if (diff == minDiff) {
//                count += 1;
//            }
//
//            // 4. sum이 k보다 크면 왼쪽 인덱스 옮김 / 그 외면 오른쪽 인덱스 옮김
//            if (k - sum < 0) {
//                right -= 1;
//            } else {
//                left += 1;
//            }
//        }
//
//        private int getCount() {
//            return count;
//        }
//    }
//}

import java.io.*;
import java.util.*;

public class Boj_9024 {
    public static void main(String[] args) throws IOException {
        // 0. 반복 횟수 입력받고 반복
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // list는 메모리가 크므로 재활용
        int[] intList = new int[1000000];

        for (int i = 0; i < n; i++) {

            // 1. 변수와 인자 setting
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < s; j++) {
                intList[j] = Integer.parseInt(st.nextToken());
            }

            // 2. 정렬
            Arrays.sort(intList, 0, s);

            // 3. 반복 전 초기값 setting
            int left = 0;
            int right = s - 1;
            int minDiff = Integer.MAX_VALUE;
            int count = 0;

            // 4. 반복하며 왼쪽 index 와 오른쪽 index를 옮겨가며 투포인터로 찾음
            while (left < right) {
                // 1. 왼쪽값와 오른쪽값의 합을 구함
                int sum = intList[left] + intList[right];

                // 2. 합과 k를 비교
                int diff = Math.abs(k - sum);

                // 3. 최소값이면 count = 1, minDiff 초기화 / 같으면 count += 1
                if (diff < minDiff) {
                    count = 1;
                    minDiff = diff;
                } else if (diff == minDiff) {
                    count += 1;
                }

                // 4. sum이 k보다 크면 왼쪽 인덱스 옮김 / 그 외면 오른쪽 인덱스 옮김
                if (k - sum < 0) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }

            System.out.println(count);
        }
    }
}