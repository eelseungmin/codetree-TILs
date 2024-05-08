import java.util.*;

public class Main {
    static int n, ans;
    static int[] dx = {-1, -1, 1, 1}; // 1 - 2 - 3 - 4
    static int[] dy = {1, -1, -1, 1};
    static int[][] map;
    static boolean[][] vis;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 시작 위치를 기억해두고 숫자대로 순회를 하면서 합을 구한 뒤 최대값 갱신
        // 이때 격자를 벗어나기 전까지 계속해서 한 방향으로 이동
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = i;
                int y = j;

                int sum = 0;
                int success = 0;
                // flag가 true일 때 최대값 갱신
                for (int k = 0; k < 4; k++) {
                    int cnt = 0;
                    while (true) {
                        x += dx[k];
                        y += dy[k];
                        if (!inRange(x, y)) {
                            // 최소 한 번은 이동해야 기울어진 직사각형 조건 충족
                            if (cnt < 1) break;
                            else {
                                x -= dx[k];
                                y -= dy[k];
                                success++;
                                break;
                            }
                        }
                        cnt++;
                        sum += map[x][y];
                        if (k == 3 && x == i && y == j) {
                            success++;
                            break;
                        }
                    }
                }

                if (success == 4)
                    ans = Math.max(ans, sum);
            }
        }

        System.out.print(ans);
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}