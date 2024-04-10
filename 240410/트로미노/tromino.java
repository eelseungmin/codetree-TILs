import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][][] shapes = new int[][][] {
        {{1, 1, 0},
        {1, 0, 0},
        {0, 0, 0}},

        {{1, 1, 0},
        {0, 1, 0},
        {0, 0, 0}},

        {{1, 0, 0},
        {1, 1, 0},
        {0, 0, 0}},

        {{0, 1, 0},
        {1, 1, 0},
        {0, 0, 0}},

        {{1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}},

        {{1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}}
    };

    static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            boolean flag = true;
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (shapes[i][j][k] == 0) continue;
                    if (x + j >= n || y + k >= m) flag = false;
                    else {
                        sum += map[x + j][y + k];
                    }
                }
            }

            if (flag) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        // ㄴ, ㅡ
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, getMaxSum(i, j));
            }
        }

        System.out.print(ans);
    }
}