import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String s = sc.next();
        int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
        int[] dy = {0, 1, 0, -1};
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int x = n / 2;
        int y = n / 2;
        int ans = map[x][y];
        int dir = 0;
        for (int i = 0; i < t; i++) {
            char cmd = s.charAt(i);
            if (cmd == 'L') {
                if (dir == 0) dir = 3;
                else dir -= 1;
            } else if (cmd == 'R') {
                if (dir == 3) dir = 0;
                else dir += 1;
            } else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                x += dx[dir];
                y += dy[dir];
                ans += map[x][y];
            }
        }

        System.out.print(ans);
    }
}