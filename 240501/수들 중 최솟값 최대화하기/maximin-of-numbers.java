import java.util.*;

public class Main {
    static int n, ans;
    static int[][] num;
    static boolean[] vis;
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        choose(0, Integer.MAX_VALUE);

        System.out.print(ans);
    }

    static void choose(int row, int min) {
        if (row == n) {
            ans = Math.max(ans, min);

            return;
        }

        for (int col = 0; col < n; col++) {
            if (!vis[col]) {
                vis[col] = true;
                choose(row + 1, Math.min(min, num[row][col]));
                vis[col] = false;
            }
        }
    }
}