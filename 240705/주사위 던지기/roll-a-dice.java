import java.util.*;

public class Main {
    static int n, m, r, c, top, front, right;
    static int[] dx = {0, 0, -1, 1}; // LRUD
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static char[] info;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        map = new int[n + 1][n + 1];
        map[r][c] = 6;
        top = 1;
        front = 2;
        right = 3;
        info = new char[m];
        for (int i = 0; i < m; i++) {
            info[i] = sc.next().charAt(0);
        }

        for (int i = 0; i < m; i++) {
            // 움직일 방향 확인
            // 방향대로 움직였을 때 격자 밖으로 벗어난다면 현재 시도는 스킵
            // 격자 안이라면 주사위 바닥 면 숫자를 격자에 기록
            if (canMove(info[i])){
                simulation(info[i]);
            } else continue;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != 0) ans += map[i][j];
            }
        }

        System.out.print(ans);
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static boolean canMove(char dir) {
        if (dir == 'L') {
            int nx = r + dx[0];
            int ny = c + dy[0];

            if (inRange(nx, ny)) {
                r += dx[0];
                c += dy[0];
                return true;
            }
        } else if (dir == 'R') {
            int nx = r + dx[1];
            int ny = c + dy[1];

            if (inRange(nx, ny)) {
                r += dx[1];
                c += dy[1];
                return true;
            }
        } else if (dir == 'U') {
            int nx = r + dx[2];
            int ny = c + dy[2];

            if (inRange(nx, ny)) {
                r += dx[2];
                c += dy[2];
                return true;
            }
        } else {
            int nx = r + dx[3];
            int ny = c + dy[3];

            if (inRange(nx, ny)) {
                r += dx[3];
                c += dy[3];
                return true;
            }
        }

        return false;
    }

    public static void simulation(char dir) {
        int pfront = front;
        int pright = right;
        int ptop = top;

        if (dir == 'L') {
            map[r][c] = 7 - pright;
            top = pright;
            front = pfront;
            right = 7 - ptop;
        } else if (dir == 'R') {
            map[r][c] = pright;
            top = 7 - pright;
            front = pfront;
            right = ptop;
        } else if (dir == 'U') {
            map[r][c] = 7 - pfront;
            top = pfront;
            front = 7 - ptop;
            right = pright;
        } else {
            map[r][c] = pfront;
            top = 7 - pfront;
            front = ptop;
            right = pright;
        }
    }
}