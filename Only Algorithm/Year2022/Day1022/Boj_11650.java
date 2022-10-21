import java.util.*;

public class Boj_11650 {
    public static void main(String[] args) {
        // 1. 스캐너 정의
        Scanner sc = new Scanner(System.in);
        // 2. 스캐너를 통해 점 개수를 가져온다.
        int n = sc.nextInt();
        // 3. 점을 담아둘 우선순위큐를 생성한다.
        Queue<Dot> dotPriorityQueue = Dot.generatePriorityQueue();
        // 4. 점 개수만큼 반복하며, 받아온 점을 차례대로 우선순위 큐에 쌓는다.
        for (int i = 0; i < n; i++) {
            Dot getOne = Dot.generateDot(sc.nextInt(), sc.nextInt());
            dotPriorityQueue.add(getOne);
        }
        // 5. 큐의 점을 순서대로 출력한다.
        printDotQueue(dotPriorityQueue);
    }

    // Queue에 있는 모든 정렬된 점을 x, y 순서대로 콘솔창에 출력하는 메서드
    private static void printDotQueue(Queue<Dot> dotPriorityQueue) {
        while (!dotPriorityQueue.isEmpty()) {
            System.out.println(dotPriorityQueue.poll().toString());
        }
    }

    static class Dot {
        private int x;

        private int y;

        private void setX(int x) {
            this.x = x;
        }

        private void setY(int y) {
            this.y = y;
        }

        private int getX() {
            return x;
        }

        private int getY() {
            return y;
        }

        // 점을 생성하여 반환하는 메서드
        public static Dot generateDot(int x, int y) {
            Dot dot = new Dot();
            dot.setX(x);
            dot.setY(y);
            return dot;
        }

        // 점 a와 점 b를 비교하여 a가 더 작으면 false, a가 더 크면 true를 반환하는 메서드
        public static boolean compare(Dot a, Dot b) {
            // 1. x값을 비교하여 a가 더 크면 true, a가 더 작으면 false
            if (a.getX() > b.getX()) {
                return true;
            } else if (a.getX() < b.getX()) {
                return false;
            }

            // 2. y값을 비교하여 a가 더 크면 true, 나머지는 false
            return a.getY() > b.getY();
        }

        // 점을 데이터로 갖는 우선순위 큐를 생성해주는 메서드
        public static Queue<Dot> generatePriorityQueue() {
            // 1. 점의 우선순위를 정한다.
            Comparator<Dot> comparator = (o1, o2) -> {
                if (compare(o1, o2)) {
                    return 1;
                } else {
                    return -1;
                }
            };
            // 2. 해당 규칙을 바탕으로 우선순위를 생성한다.
            return new PriorityQueue<>(comparator);
        }

        @Override
        public String toString() {
            return this.getX() +
                    " " +
                    this.getY();
        }
    }
}