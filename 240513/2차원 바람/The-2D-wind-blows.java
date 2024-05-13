import java.util.*;

class Wind {
    int r1, c1, r2, c2;

    Wind(int r1, int c1, int r2, int c2) {
        this.r1 = r1;
        this.c1 = c1;
        this.r2 = r2;
        this.c2 = c2;
    }
}

public class Main {
    static int n, m, q;
    static int[][] map;
    static Wind[] info;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        map = new int[n][m];
        info = new Wind[q];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < q; i++) {
            info[i] = new Wind(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1);
        }

        for (int i = 0; i < q; i++) {
            Wind cur = info[i];

            shift(cur);
            avg(cur);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void shift(Wind wind) {
        int temp = map[wind.r1][wind.c1];

        for (int i = wind.r1 + 1; i <= wind.r2; i++) {
            map[i - 1][wind.c1] = map[i][wind.c1];
        }

        for (int i = wind.c1 + 1; i <= wind.c2; i++) {
            map[wind.r2][i - 1] = map[wind.r2][i];
        }
        
        for (int i = wind.r2 - 1; i >= wind.r1; i--) {
            map[i + 1][wind.c2] = map[i][wind.c2];
        }

        for (int i = wind.c2 - 1; i > wind.c1; i--) {
            map[wind.r1][i + 1] = map[wind.r1][i];
        }

        map[wind.r1][wind.c1 + 1] = temp;
    }

    static void avg(Wind wind) {
        int[][] temp = new int[n][m];

        for (int i = wind.r1; i <= wind.r2; i++) {
            for (int j = wind.c1; j <= wind.c2; j++) {
                int sum = map[i][j];
                int cnt = 1;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        sum += map[nx][ny];
                        cnt++;
                    }
                }

                temp[i][j] = (int) ((double) sum / cnt);
            }
        }

        for (int i = wind.r1; i <= wind.r2; i++) {
            for (int j = wind.c1; j <= wind.c2; j++) {
                map[i][j] = temp[i][j];
            }
        }
    }
}