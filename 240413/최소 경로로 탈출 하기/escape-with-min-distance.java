import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dist;
    static int n, m;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs(0, 0);

        if (dist[n - 1][m - 1] != -1) {
            System.out.print(dist[n - 1][m - 1]);
        } else {
            System.out.print(-1);
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        dist[x][y]++;
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && dist[nx][ny] == -1 && map[nx][ny] == 1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
    }
}