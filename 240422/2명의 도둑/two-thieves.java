import java.util.*;

// 같은 행을 골랐을 때 겹치는 경우는 2가지
// 행 2중 for문으로 선택 후 열의 조합 선택

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n - m; k++) {
                    for (int h = 0; h < n - m; h++) {
                        if (i == j && (k == h) || (k == h + 1) || (h == k + 1)) continue;
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
                            } else {
                                break;
                            }
                        }
                        while (!pq2.isEmpty()) {
                            int cur = pq2.poll();
                            if (weight2 + cur <= c) {
                                weight2 += cur;
                                val += cur * cur;
                            } else {
                                break;
                            }
                        }
                        ans = Math.max(ans, val);
                    }
                }
            }
        }
        
        System.out.print(ans);
    }
}