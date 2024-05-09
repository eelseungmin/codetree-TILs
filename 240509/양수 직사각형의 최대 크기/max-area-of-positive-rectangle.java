import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int ans = -1;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 두 개의 꼭지점 설정 후 내부 숫자가 양수인지 확인하고 맞다면 직사각형의 최대 크기 갱신
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                for (int x2 = x1; x2 < n; x2++) {
                    for (int y2 = y1; y2 < m; y2++) {
                        ans = Math.max(ans, getArea(x1, y1, x2, y2));
                    }
                }
            }
        }

        System.out.print(ans);
    }

    static int getArea(int x1, int y1, int x2, int y2) {
        if (!check(x1, y1, x2, y2)) {
            return -1;
        }

        return Math.abs(x2 - x1 + 1) * Math.abs(y2 - y1 + 1);
    }

    static boolean check(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] <= 0) {
                    return false;
                }
            }
        }

        return true;
    }
}