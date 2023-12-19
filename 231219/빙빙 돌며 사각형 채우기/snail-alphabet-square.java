import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map;
    static int n, m, x, y, dir, val, cnt, end;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        map = new char[n][m];
        x = 0; y = 0;
        map[0][0] = 'A';
        dir = 0;
        val = 'A';
        cnt = 1;
        end = n * m - 1;
        while (end-- > 0) {
            if (cnt == 26) {
                cnt = 0;
            }
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if ((nx < 0 || nx >= n || ny < 0 || ny >= m) || map[nx][ny] != '\u0000') {
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];
            map[x][y] = (char)((int) val + cnt);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}