import java.util.*;

class Node implements Comparable<Node> {
    int k;
    int area;

    Node(int k, int area) {
        this.k = k;
        this.area = area;
    }

    @Override
    public int compareTo(Node n) {
        if (this.area == n.area) {
            return this.k - n.k;
        }
        return n.area - this.area;
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        List<Node> list = new ArrayList<>();
        for (int k = 1; k <= 100; k++) {
            vis = new boolean[n][m];
            int area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!vis[i][j] && map[i][j] - k > 0) {
                        vis[i][j] = true;
                        dfs(i, j, k);
                        area++;
                    }
                }
            }
            // System.out.println(k + " " + area);
            list.add(new Node(k, area));
        }

        Collections.sort(list);
    
        System.out.print(list.get(0).k + " " + list.get(0).area);
    }

    static void dfs(int x, int y, int k) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny] && map[nx][ny] - k > 0) {
                vis[nx][ny] = true;
                dfs(nx, ny, k);
            }
        }
    }
}