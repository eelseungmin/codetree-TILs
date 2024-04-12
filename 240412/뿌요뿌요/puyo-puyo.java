import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] vis;
    static int[][] map;
    static int n;
    static int cnt;
    static boolean exploded;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt(); 
            }
        }

        int max = 0;
        int block = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                exploded = false;
                if (!vis[i][j]) {
                    vis[i][j] = true;
                    cnt = 1;
                    dfs(i, j, map[i][j]);
                    if (cnt >= 4) {
                        exploded = true;
                    }
                    if (exploded) {
                        block++;
                    }
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.print(block + " " + max);
    }

    static void dfs(int x, int y, int val) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx & nx < n && 0 <= ny && ny < n && !vis[nx][ny] && map[nx][ny] == val) {
                vis[nx][ny] = true;
                cnt++;
                dfs(nx, ny, val);
            }
        }
    }
}