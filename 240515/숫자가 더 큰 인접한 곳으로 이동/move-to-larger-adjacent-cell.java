import java.util.*;

public class Main {
    static int n, r, c;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int curx = r;
        int cury = c;
        System.out.print(map[curx][cury] + " ");
        while (true) {
            int cnt = 0;
            int newx = -1;
            int newy = -1;
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] > map[curx][cury]) {
                    cnt++;
                    newx = nx;
                    newy = ny;
                }
            }
            
            if (cnt == 0) {
                break;
            } else if (cnt == 1) {
                curx = newx;
                cury = newy;
                System.out.print(map[newx][newy] + " ");
                continue;
            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = curx + dx[i];
                    int ny = cury + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] > map[curx][cury]) {
                        curx = nx;
                        cury = ny;
                        System.out.print(map[nx][ny] + " ");
                        break;
                    }
                }
            }
        }
    }
}