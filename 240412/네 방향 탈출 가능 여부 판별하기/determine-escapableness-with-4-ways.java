import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] vis;
    static int n, m;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        if (map[0][0] == 1) {
            bfs();
        }

        if (vis[n - 1][m - 1]) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        vis[0][0] = true;
        q.offer(new Pair(0, 0));
        
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny] && map[nx][ny] != 0) {
                    vis[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
    }
}