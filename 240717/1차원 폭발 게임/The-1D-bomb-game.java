import java.util.*;

class Pair {
    int l, r;

    Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

public class Main {
    static int n, m;
    static List<Integer> list;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        while (true) {
            // 현재 상태에서 m개 이상 연속한 폭탄이 있는지 확인, 없으면 종료
            if (list.isEmpty() || !check()) {
                break;
            }

            // 연속한 폭탄 터뜨리기
            simulation();
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static boolean check() {
        int target = list.get(0);
        int len = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == target) {
                len++;
                if (len >= m) return true;
            } else {
                target = list.get(i);
                len = 1;
            }
        }

        return false;
    }

    static void simulation() {
        boolean[] temp = new boolean[list.size()];
        Queue<Integer> q = new LinkedList<>();

        int l = 0;
        int r = 0;
        int len = 1;
        int target = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == target) {
                r++;
                len++;
            } else {
                if (len >= m) {
                    for (int j = l; j <= r; j++) {
                        temp[j] = true;
                    }
                }
                target = list.get(i);
                l = i;
                r = i;
                len = 1;
            }
        }
        if (len >= m) {
            for (int j = l; j <= r; j++) {
                temp[j] = true;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (!temp[i]) {
                q.offer(list.get(i));
            }
        }

        list.clear();
        while (!q.isEmpty()) list.add(q.poll());
    }
}