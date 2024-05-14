import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int r, c, m1, m2, m3, m4, dir;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        dir = sc.nextInt();

        rotate();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate() {
        // 반시계면 시계 방향으로
        if (dir == 0) {
            int temp = map[r][c];
            int x = r;
            int y = c;
            for (int i = 0; i < m4; i++) {
                x += dx[1];
                y += dy[1];
                map[x + dx[3]][y + dy[3]] = map[x][y];
            }

            for (int i = 0; i < m3; i++) {
                x += dx[0];
                y += dy[0];
                map[x + dx[2]][y + dy[2]] = map[x][y]; 
            }

            for (int i = 0; i < m2; i++) {
                x += dx[3];
                y += dy[3];
                map[x + dx[1]][y + dy[1]] = map[x][y];
            }

            for (int i = 0; i < m1; i++) {
                x += dx[2];
                y += dy[2];
                map[x + dx[0]][y + dy[0]] = map[x][y];
            }

            map[r + dx[0]][c + dy[0]] = temp;
        } else { // 시계면 반시계 방향으로
            int temp = map[r][c];
            int x = r;
            int y = c;
            for (int i = 0; i < m1; i++) {
                x += dx[0];
                y += dy[0];
                map[x + dx[2]][y + dy[2]] = map[x][y];
            }

            for (int i = 0; i < m2; i++) {
                x += dx[1];
                y += dy[1];
                map[x + dx[3]][y + dy[3]] = map[x][y]; 
            }

            for (int i = 0; i < m3; i++) {
                x += dx[2];
                y += dy[2];
                map[x + dx[0]][y + dy[0]] = map[x][y];
            }

            for (int i = 0; i < m4; i++) {
                x += dx[3];
                y += dy[3];
                map[x + dx[1]][y + dy[1]] = map[x][y];
            }

            map[r + dx[1]][c + dy[1]] = temp;
        }
    }
}