import java.util.*;

public class Main {
    static int n, curx, cury, dir;
    static char[][] maze;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] vis;
    static int time;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        curx = sc.nextInt();
        cury = sc.nextInt();
        maze = new char[n + 1][n + 1];
        vis = new boolean[n + 1][n + 1][4];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i + 1][j + 1] = tmp.charAt(j);
            }
        }

        while (inRange(curx, cury)) {
            simulation();
        }

        System.out.print(time);
    }

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    public static boolean wallExist(int x, int y) {
        return inRange(x, y) && maze[x][y] == '#';
    }

    public static void simulation() {
        // 방문 여부 확인
        if (vis[curx][cury][dir]) {
            System.out.print(-1);
            System.exit(0);
        }

        // 방문 체크
        vis[curx][cury][dir] = true;
        
        int nx = curx + dx[dir];
        int ny = cury + dy[dir];

        // case 1
        if (wallExist(nx, ny)) {
            dir = (dir - 1 + 4) % 4;
        }

        // case 2
        else if (!inRange(nx, ny)) {
            curx = nx;
            cury = ny;
            time++;
        }

        // case 3
        else {
            int nnx = nx + dx[(dir + 1) % 4];
            int nny = ny + dy[(dir + 1) % 4];

            // case 3-1
            if (wallExist(nnx, nny)) {
                curx = nx;
                cury = ny;
                time++;
            }

            // case 3-2
            else {
                curx = nnx;
                cury = nny;
                dir = (dir + 1) % 4;
                time += 2;
            }
        }
    }
}