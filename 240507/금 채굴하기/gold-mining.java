import java.util.*;

public class Main {
    static int n, m, ans;
    static int[][] map;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 격자의 각 위치가 마름모의 중앙일 때 k를 최대 범위까지 늘려가면서 금의 최대 개수 갱신
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2 * (n - 1); k++) {
                    int gold = calculate(i, j, k);

                    if (m * gold >= getArea(k)) {
                        ans = Math.max(ans, gold);
                    }
                }
            }
        }

        System.out.print(ans);
    }

    static int getArea(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    static int calculate(int row, int col, int k) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(row - i) + Math.abs(col - j) <= k)
                    cnt += map[i][j];
            }
        }

        return cnt;
    }
}