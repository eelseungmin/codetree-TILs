import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.x == p.x) {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] vis;
    static int n, k, r, c;
    static List<Pair> cand;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        while (k-- > 0) {
            vis = new boolean[n][n];
            cand = new ArrayList<>();
            bfs(r, c);
            if (!check()) break;
        }

        System.out.print((r + 1) +  " " + (c + 1));
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        vis[x][y] = true;
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !vis[nx][ny] && map[nx][ny] < map[x][y]) {
                    vis[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                    cand.add(new Pair(nx, ny));
                }
            }
        }
    }

    static boolean check() {
        if (cand.isEmpty()) {
            return false;
        }

        int maxVal = -1;
        for (Pair p : cand) {
            maxVal = Math.max(maxVal, map[p.x][p.y]);
        }

        List<Pair> target = new ArrayList<>();
        for (Pair p : cand) {
            if (map[p.x][p.y] == maxVal) {
                target.add(new Pair(p.x, p.y));
            }
        }

        Collections.sort(target);

        r = target.get(0).x;
        c = target.get(0).y;
        return true;
    }
}