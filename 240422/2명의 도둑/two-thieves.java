import java.util.*;

// 행 선택 후 열 선택

public class Main {
    static int n, m, c, ans;
    static int[][] item;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        item = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                item[i][j] = sc.nextInt();
            }
        }

        // k k+m h h+m
        // 1 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n - m; k++) {
                    for (int h = 0; h <= n - m; h++) {
                        if (i == j && (
                            (k <= h && h <= k + m - 1) || 
                            (k <= h + m - 1 && h + m - 1 <= k + m - 1) ||
                            (h <= k && k <= h + m - 1) ||
                            (h <= k + m - 1 && k + m - 1 <= h + m - 1))
                            ) continue;
                        int weight1 = 0;
                        int weight2 = 0;
                        int val = 0;
                        Queue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
                        Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
                        for (int p = 0; p < m; p++) {
                            pq1.offer(item[i][k + p]);
                            pq2.offer(item[j][h + p]);
                        }
                        while (!pq1.isEmpty()) {
                            int cur = pq1.poll();
                            if (weight1 + cur <= c) {
                                weight1 += cur;
                                val += cur * cur;
                            }
                        }
                        while (!pq2.isEmpty()) {
                            int cur = pq2.poll();
                            if (weight2 + cur <= c) {
                                weight2 += cur;
                                val += cur * cur;
                            }
                        }
                        if (ans < val) {
                            ans = val;
                            // System.out.println(i + " " + k + " " + j + " " + h);
                        }
                    }
                }
            }
        }
        
        System.out.print(ans);
    }
}