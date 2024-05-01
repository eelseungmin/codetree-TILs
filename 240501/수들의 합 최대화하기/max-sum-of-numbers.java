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

        choose(0, 0);

        System.out.print(ans);
    }
    
    // 어차피 각 열마다, 각 행마다 한번씩은 칠해줘야 하므로
    // n X n의 모든 칸에 대해 고려하는게 아니라 각 행마다 열 하나하나에 대해 백트래킹을 수행하는 식으로 구한다.
    static void choose(int row, int sum) {
        if (row == n) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                choose(row + 1, sum + num[row][i]);
                vis[i] = false;
            }
        }
    }
}