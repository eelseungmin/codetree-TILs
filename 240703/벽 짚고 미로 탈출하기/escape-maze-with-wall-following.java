import java.util.*;

public class Main {
    static int n, curx, cury;
    static char[][] maze;
    static int dir;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int time;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        curx = sc.nextInt();
        cury = sc.nextInt();
        maze = new char[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i + 1][j + 1] = tmp.charAt(j);
            }
        }

        simulation();
    }

    public static void simulation() {
        int cnt = 0;

        while (true) {
            int flag = canMove(curx, cury, dir);
            if (flag == 0) {
                if (cnt > 3) {
                    System.out.print(-1);
                    return;
                }
                dir = (dir + 1) % 4;
                cnt++;
                continue;
            } else if (flag == 1) {
                cnt = 0;
                curx += dx[dir];
                cury += dy[dir];
            } else {
                time++;
                break;
            }
            time++;
        }

        System.out.print(time);
    }

    public static int canMove(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (1 <= nx && nx <= n && 1 <= ny && ny <= n) {
            if (maze[nx][ny] == '#') {
                return 0;
            }
            return 1; 
        }

        return 2;
    }
}