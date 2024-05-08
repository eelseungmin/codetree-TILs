import java.util.*;

public class Main {
    static int n, ans;
    static int[] dx = {-1, -1, 1, 1}; // 1 - 2 - 3 - 4
    static int[] dy = {1, -1, -1, 1};
    static int[][] map;

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

        // 완전탐색을 통해 최대값 갱신
        // 시작 위치 i, j 선택 후 길이 [k, l, k, l] 선택
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    for (int l = 1; l < n; l++) {
                        ans = Math.max(ans, getScore(i, j, k, l));
                    }
                }
            }
        }

        System.out.print(ans);
    }

    static int getScore(int x, int y, int k, int l) {
        int sum = 0;
        int[] moveNum = new int[]{k, l, k, l};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < moveNum[i]; j++) {
                x += dx[i];
                y += dy[i];

                if (!inRange(x, y))
                    return 0;
                
                sum += map[x][y];
            }
        }

        return sum;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}