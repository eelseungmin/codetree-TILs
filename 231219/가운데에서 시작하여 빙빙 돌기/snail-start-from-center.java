import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int n;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 항상 홀수
        map = new int[n][n];
        int num = 1;
        int dir = 0;
        int x = n / 2;
        int y = n / 2;
        map[x][y] = 1;
        int end = 1;
        while (end++ < n * n) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if ((nx < 0 || nx >= n || ny < 0 || ny >= n) || map[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];
            map[x][y] = end;
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