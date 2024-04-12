import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static boolean[][] vis;
    static int[][] map;
    static int person;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        vis = new boolean[n][n];
        List<Integer> town = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && map[i][j] == 1) {
                    vis[i][j] = true;
                    person = 1;
                    dfs(i, j);
                    town.add(person);
                }
            }
        }

        Collections.sort(town);

        System.out.println(town.size());
        for (int i = 0; i < town.size(); i++) {
           System.out.println(town.get(i)); 
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n && !vis[nx][ny] && map[nx][ny] == 1) {
                vis[nx][ny] = true;
                person++;
                dfs(nx, ny);
            }
        }
    }
}