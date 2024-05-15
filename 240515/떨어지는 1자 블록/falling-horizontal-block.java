import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static int[] dx = {1};
    static int[] dy = {0};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt() - 1;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1){
                for (int j = k; j <= k + m - 1; j++) {
                    if (j < n) {
                        map[i][j] = 1;
                    }
                }
                break;
            }
            if (check(i)) {
                for (int j = k; j <= k + m - 1; j++) {
                    if (j < n) {
                        map[i][j] = 1;
                    }
                }
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean check(int row) {
        for (int i = k; i <= k + m - 1; i++) {
            if (row + 1 < n && map[row + 1][i] == 1) {
                return true;
            }
        }

        return false;
    }
}