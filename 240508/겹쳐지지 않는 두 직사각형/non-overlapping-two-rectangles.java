import java.util.*;

public class Main {
    static int n, m;
    static int ans = Integer.MIN_VALUE;
    static int[][] map;

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

        // i, j로 1번 직사각형 왼쪽 상단 꼭지점 선택
        // k, l로 2번 직사각형 왼쪽 상단 꼭지점 선택
        // 나머지로 각각의 가로 세로 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        for (int p = 1; p < n; p++) {
                            for (int q = 1; q < m; q++) {
                                for (int r = 1; r < n; r++) {
                                    for (int s = 1; s < m; s++) {
                                        ans = Math.max(ans, getScore(i, j, k, l, p, q, r, s));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }

    static int getScore(int i, int j, int k, int l, int p, int q, int r, int s) {
        // 겹치면 바로 return
        if (!(l + s <= j || l >= j + q || i + p <= k || k + r <= i))
            return Integer.MIN_VALUE;

        int sum1 = 0;
        int sum2 = 0;
        for (int a = i; a < i + p; a++) {
            for (int b = j; b < j + q; b++) {
                if (!inRange(a, b)) {
                    return Integer.MIN_VALUE;
                }
                
                sum1 += map[a][b];
            }
        }

        for (int c = k; c < k + r; c++) {
            for (int d = l; d < l + s; d++) {
                if (!inRange(c, d)) {
                    return Integer.MIN_VALUE;
                }

                sum2 += map[c][d];
            }
        }

        return sum1 + sum2;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}