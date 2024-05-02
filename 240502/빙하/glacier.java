import java.util.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, area;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] exter;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 매번 n * m을 탐색하면서 1로 둘러싸인 0을 특정 배열에 표시한다.
        // 표시된 영역을 제외하고 1에서 상하좌우를 탐색하며 0에 한칸이라도 닿아 있으면 1을 0으로 바꾼다.
        int time = 0;
        while (!isWater()) {
            time++;
            bfs();
            simulation();
        }

        System.out.print(time + " " + area);
    }

    static boolean isWater() {
        int ice = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    ice++;
                }
            }
        }
        
        if (ice != 0) 
            return false;
        return true;
    }

    static void simulation() {
        area = 0;
        List<Pair> melt = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && check(i, j)) {
                    area++;
                    melt.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < melt.size(); i++) {
            Pair cur = melt.get(i);

            map[cur.x][cur.y] = 0;
        }
    }

    static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[nx][ny] == 0 && exter[nx][ny]) {
                return true;
            }
        }

        return false;
    }

    static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        exter = new boolean[n][m];
        vis[0][0] = true;
        exter[0][0] = true;
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny] && map[nx][ny] == 0) {
                    vis[nx][ny] = true;
                    exter[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
    }
}