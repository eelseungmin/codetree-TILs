import java.util.*;

public class Main {
    static int n = 0;
    static int m = 0;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x = 0;
    static int y = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        int num = 0;
        int dir = 0;
        while (num < n * m) {
            num++;
            map[x][y] = num;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
                x += dx[dir];
                y += dy[dir];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}