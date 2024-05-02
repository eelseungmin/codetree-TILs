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
    static int n, k, m, ans;
    static int[][] map;
    static List<Pair> start = new ArrayList<>();
    static List<Pair> rock = new ArrayList<>();
    static int[] comb;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][n + 1];
        comb = new int[m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    rock.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < k; i++) {
            start.add(new Pair(sc.nextInt(), sc.nextInt()));
        }

        // 미리 기록한 돌의 위치들을 이용해서 m개만 고르는 조합을 구한다.
        // 구해진 조합대로 돌을 지우고 bfs를 수행한 뒤 최댓값을 갱신한다.
        choose(0, -1);

        System.out.print(ans);
    }

    static void choose(int idx, int last) {
        if (idx == m) {
            bfs();
            return;
        }

        for (int i = last + 1; i < rock.size(); i++) {
            comb[idx] = i;
            choose(idx + 1, i);
        }
    }

    static void bfs() {
        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n + 1][n + 1];
        for (int i = 0; i < k; i++) {
            Pair cur = start.get(i);
            vis[cur.x][cur.y] = true;
            cnt++;
            q.offer(cur);
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 < nx && nx <= n && 0 < ny && ny <= n && !vis[nx][ny]) {
                    if (map[nx][ny] == 0 || (map[nx][ny] == 1 && check(nx, ny))) {
                        vis[nx][ny] = true;
                        cnt++;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        ans = Math.max(ans, cnt);
    }

    static boolean check(int nx, int ny) {
        for (int i = 0; i < m; i++){
            Pair cur = rock.get(comb[i]);
            if (cur.x == nx && cur.y == ny)
                return true;
        }

        return false;
    }
}