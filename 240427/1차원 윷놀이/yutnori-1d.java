import java.util.*;

public class Main {
    static int n, m, k, ans;
    static int[] possible;
    static int[] dist;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        possible = new int[n];
        dist = new int[k];
        for (int i = 0; i < n; i++) {
            possible[i] = sc.nextInt();
        }

        go(0);

        System.out.print(ans);
    }

    static void go(int idx) {
        if (idx == n) {
            int score = 0;
            for (int i = 0; i < k; i++) {
                if (dist[i] >= m - 1) {
                    score++;
                }
            }
            ans = Math.max(ans, score);
            return;
        }

        for (int i = 0; i < k; i++) {
            dist[i] += possible[idx];
            go(idx + 1);
            dist[i] -= possible[idx];
        }
    }
}