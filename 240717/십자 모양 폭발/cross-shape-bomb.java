import java.util.*;

public class Main {
    static int n, r, c;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt();
        c = sc.nextInt();

        simulation();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void simulation() {
        // 범위 만큼 폭탄 터뜨리기
        int num = map[r][c] - 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= num; j++) {
                int nx = r + dx[i] * j;
                int ny = c + dy[i] * j;

                if (!inRange(nx, ny)) break;
                map[nx][ny] = 0;
            }
        }

        // 중력에 따라 숫자 떨어뜨리기 
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            for (int j = n; j >= 1; j--) {
                if (map[j][i] == 0) {
                    flag = true;
                    continue;
                }
                
                int tmp = 0;
                if (flag) {
                    tmp = map[j + 1][i];
                    map[j + 1][i] = map[j][i];
                    map[j][i] = tmp;
                }
            }
        }
    }

    static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }
}