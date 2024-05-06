import java.util.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, k;
    static int time = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] vis;
    static List<Pair> wall = new ArrayList<>();
    static List<Pair> select = new ArrayList<>();
    static int r1, c1, r2, c2;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    wall.add(new Pair(i, j));
                }
            }
        }
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        choose(0, -1);

        if (time == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(time);
    }

    static void choose(int idx, int last) {
        if (idx == k) {
            bfs();
            // for (int i = 0; i < n; i++) {
            //     for (int j = 0; j < n; j++) {
            //         System.out.print(vis[i][j] + " ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("end");
            if (vis[r2 - 1][c2 - 1] != -1)
                time = Math.min(time, vis[r2 - 1][c2 - 1]);
            return;
        }

        for (int i = last + 1; i < wall.size(); i++) {
            select.add(wall.get(i));
            choose(idx + 1, i);
            select.remove(select.size() - 1);
        }
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], -1);
        }
        vis[r1 - 1][c1 - 1]++;
        q.offer(new Pair(r1 - 1, c1 - 1));
        int cnt = k;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && vis[nx][ny] == -1) {
                    if (map[nx][ny] == 1) {
                        if (cnt > 0 && check(nx, ny)) {
                            cnt--;
                        } else
                            continue;
                    }

                    vis[nx][ny] = vis[cur.x][cur.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < k; i++) {
            if (select.get(i).x == x && select.get(i).y == y)
                return true;
        }

        return false;
    }
}