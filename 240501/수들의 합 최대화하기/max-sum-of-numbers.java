import java.util.*;

public class Main {
    static int n, ans;
    static int[][] num;
    static boolean[][] vis;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        choose(0);

        System.out.print(ans);
    }

    static void choose(int idx) {
        if (idx == n) {
            ans = Math.max(ans, calcSum());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    vis[i][j] = true;
                    if (check())
                        choose(idx + 1);
                    vis[i][j] = false;
                }
            }
        }
    }

    static boolean check() {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    if (!row[i]) row[i] = true;
                    else return false;
                    if (!col[j]) col[j] = true;
                    else return false;
                }
            }
        }

        return true;
    }

    static int calcSum() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    sum += num[i][j];
                }
            }
        }

        return sum;
    }
}