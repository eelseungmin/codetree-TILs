import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int before = -1;
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == before) {
                    cnt++;
                } else if (before == -1) {
                    before = map[j][i];
                } else {
                    before = map[j][i];
                    cnt = 1;
                }
                if (cnt >= m) {
                    ans++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int before = -1;
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == before) {
                    cnt++;
                } else if (before == -1) {
                    before = map[i][j];
                } else {
                    before = map[i][j];
                    cnt = 1;
                }
                if (cnt >= m) {
                    ans++;
                    break;
                }
            }
        }

        System.out.print(ans);
    }
}