import java.util.*;

class Wind {
    int r;
    char d;

    Wind(int r, char d) {
        this.r = r;
        this.d = d;
    }
}

public class Main {
    static int n, m, q;
    static int[][] map;
    static Wind[] info;

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
            info[i] = new Wind(sc.nextInt() - 1, sc.next().charAt(0));
        }

        // 바람 정보를 확인하고 해당 행을 시프트한다.
        // 위의 행과 기존 행을 조건을 기준으로 비교하고 전파를 결정한다.
        // 아래 행과 기존 행을 비교하고 전파를 결정한다.
        // 나머지 바람도 마찬가지로 전파를 진행한다.
        // L이면 오른쪽으로 시프트, R이면 왼쪽으로 시프트
        for (int i = 0; i < q; i++) {
            Wind wind = info[i];

            shift(wind.r, wind.d);
            int rowT = wind.r - 1;
            int rowB = wind.r + 1;
            char windT = wind.d;
            char windB = wind.d;
            while (check(rowT, "top")) {
                if (windT == 'L') {
                    shift(rowT, 'R');
                    windT = 'R';
                } else {
                    shift(rowT, 'L');
                    windT = 'L';
                }
                rowT--;
            }
            while (check(rowB, "bottom")) {
                if (windB == 'L') {
                    shift(rowB, 'R');
                    windB = 'R';
                } else {
                    shift(rowB, 'L');
                    windB = 'L';
                }
                rowB++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void shift(int row, char dir) {
        if (dir == 'L') {
            int temp = map[row][m - 1];
            for (int i = m - 2; i >= 0; i--) {
                map[row][i + 1] = map[row][i];
            }
            map[row][0] = temp;
        } else {
            int temp = map[row][0];
            for (int i = 1; i < m; i++) {
                map[row][i - 1] = map[row][i];
            }
            map[row][m - 1] = temp;
        }
    }

    static boolean check(int row, String dir) {
        if (dir == "top") {
            if (!(0 <= row && row < n - 1)) {
                return false;
            }

            for (int i = 0; i < m; i++) {
                if (map[row][i] == map[row + 1][i]) {
                    return true;
                }
            }
        } else {
            if (!(1 <= row && row < n)) {
                return false;
            }

            for (int i = 0; i < m; i++) {
                if (map[row][i] == map[row - 1][i]) {
                    return true;
                }
            }
        }

        return false;
    }
}