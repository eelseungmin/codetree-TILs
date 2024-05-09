import java.util.*;

public class Main {
    static int n, m;
    static int ans = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] grid;

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

        // 각각 왼쪽 상단 꼭지점, 오른쪽 하단 꼭지점 설정 후 최대값 갱신
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                for (int x2 = x1; x2 < n; x2++) {
                    for (int y2 = y1; y2 < m; y2++) {
                        for (int x3 = 0; x3 < n; x3++) {
                            for (int y3 = 0; y3 < m; y3++) {
                                for (int x4 = x3; x4 < n; x4++) {
                                    for (int y4 = y3; y4 < m; y4++) {
                                        ans = Math.max(ans, getScore(x1, y1, x2, y2, x3, y3, x4, y4));
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

    static int getScore(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // 겹치는지 확인
        if (isOverlap(x1, y1, x2, y2, x3, y3, x4, y4)) {
            return Integer.MIN_VALUE;
        }

        int sum1 = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                sum1 += map[i][j];
            }
        }

        int sum2 = 0;
        for (int i = x3; i <= x4; i++) {
            for (int j = y3; j <= y4; j++) {
                sum2 += map[i][j];
            }
        }
        
        return sum1 + sum2;
    }
    
    static boolean isOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        grid = new int[n][m];
        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);
        return check();
    }

    static void draw(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                grid[i][j]++;
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}