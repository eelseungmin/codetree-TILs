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
    static int n, k;
    
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
        for (int i = 0; i < k; i++) {
            vis = new boolean[n][n];
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            bfs(r - 1, c - 1);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    cnt++;
                } 
            }
        }

        System.out.print(cnt);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        vis[x][y] = true;
        map[x][y] = 2;
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !vis[nx][ny] && map[nx][ny] != 1) {
                    map[nx][ny] = 2;
                    vis[nx][ny] = true;
                    q.offer(new Pair(nx, ny));    
                }
            }
        }
    }
}