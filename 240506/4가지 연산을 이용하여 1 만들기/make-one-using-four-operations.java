import java.util.*;

public class Main {
    static int n;
    static boolean[] vis;
    static int[] cnt;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        vis = new boolean[2000000];
        cnt = new int[2000000];

        if (n == 1) {
            System.out.print(0);
            return;
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        vis[n] = true;
        q.offer(n);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 4; i++) {
                if (!canCalculate(cur, i)) continue;
                int next = calculate(cur, i);
                if (canGo(next)) {
                    vis[next] = true;
                    cnt[next] = cnt[cur] + 1;
                    q.offer(next);
                }
            }
        }

        System.out.print(cnt[1]);
    }

    static boolean canCalculate(int cur, int i) {
        if (i == 0 || i == 1) {
            return true;
        } else if (i == 2) {
            return cur % 2 == 0;
        } else
            return cur % 3 == 0;
    }

    static int calculate(int cur, int i) {
        if (i == 0) {
            return cur - 1;
        } else if(i == 1) {
            return cur + 1;
        } else if (i == 2) {
            return cur / 2;
        } else
            return cur / 3;
    }

    static boolean canGo(int cur) {
        return inRange(cur) && !vis[cur];
    }

    static boolean inRange(int cur) {
        return 1 <= cur && cur <= 2 * n - 1;
    }
}