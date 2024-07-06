import java.util.*;

public class Main {
    static int n, m, r, c, time;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], -1);
        }
        map[r][c] = 0;

        time = 0;
        while (true) {
            time++;

            makeBomb();

            if (time == m) break;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] > -1) ans++;
            }
        }

        System.out.print(ans);
    }

    public static boolean inRange(int x, int y){
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static void makeBomb() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (-1 < map[i][j] && map[i][j] < time) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + (int) Math.pow(2, time - 1) * dx[k];
                        int ny = j + (int) Math.pow(2, time - 1) * dy[k];

                        if (!inRange(nx, ny)) continue;
                        if (map[nx][ny] != -1) continue;
                        map[nx][ny] = time;
                    }
                }
            }
        }
    }
}