import java.util.*;

// 행 선택 후 열 선택

public class Main {
    static int n, m, c, ans, maxVal;
    static int[][] item;
    static int[] arr;

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
                        if (inRange(i, j, k, h, m)) continue;
                        ans = Math.max(ans, calcVal(i, k) + calcVal(j, h));
                    }
                }
            }
        }
        
        System.out.print(ans);
    }

    static void calcMaxSum(int idx, int weight, int val) {
        if (idx == m) {
            if (weight <= c) {
                maxVal = Math.max(maxVal, val);
            }
            return;
        }

        calcMaxSum(idx + 1, weight, val);
        calcMaxSum(idx + 1, weight + arr[idx], val + arr[idx] * arr[idx]);
    }

    static int calcVal(int x, int y) {
        arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = item[x][y + i];
        }

        maxVal = 0;
        calcMaxSum(0, 0, 0);
        return maxVal;
    }

    static boolean inRange(int i, int j, int k, int h, int m) {
        return (i == j 
        && ((k <= h && h <= k + m - 1) 
        || (k <= h + m - 1 && h + m - 1 <= k + m - 1) 
        || (h <= k && k <= h + m - 1) 
        || (h <= k + m - 1 && k + m - 1 <= h + m - 1)));
    }
}