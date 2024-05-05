import java.util.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, k, u, d, ans;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Pair[] city;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        map = new int[n][n];
        city = new Pair[k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 64개 중 k개의 도시를 고른 뒤 k개의 시작점으로부터 조건에 따라 bfs를 수행한다.
        // 최대 도시의 갯수를 갱신한다.
        choose(0, -1);

        System.out.print(ans);
    }

    static void choose(int idx, int lastX) {
        if (idx == k) {
            bfs();
            return;
        }

        for (int i = lastX + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                city[idx] = new Pair(i, j);
                choose(idx + 1, lastX + 1);
            }
        }
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            vis[city[i].x][city[i].y] = true;
            cnt++;
            q.offer(city[i]);
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < n && !vis[nx][ny]) {
                    int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                    if (u <= diff && diff <= d) {
                        vis[nx][ny] = true;
                        cnt++;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        ans = Math.max(ans, cnt);
    }
}