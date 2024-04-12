import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        vis = new boolean[n][m];
        dx = new int[]{1, 0};
        dy = new int[]{0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        vis[0][0] = true;
        dfs(0, 0);

        if (vis[n - 1][m - 1]) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny] && map[nx][ny] != 1) {
                vis[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}