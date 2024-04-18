import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, ans;
    static int[] dx1 = {-2, -1, 1, 2};
    static int[] dy1 = {0, 0, 0, 0};
    static int[] dx2 = {0, 1, 0, -1};
    static int[] dy2 = {1, 0, -1, 0};
    static int[] dx3 = {-1, -1, 1, 1};
    static int[] dy3 = {-1, 1, -1, 1};
    static int[][] map;
    static int[] arr;
    static boolean[][] exploded;
    static List<Pair> bombs = new ArrayList<>();
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) bombs.add(new Pair(i, j));
            }
        }
        arr = new int[bombs.size()];

        // 위치는 정해져 있다.
        // 각 위치에 어떤 폭탄이 배치될지 조합을 구한 후 영역의 최댓값 갱신
        choose(0);

        System.out.print(ans);
    }

    static void choose(int idx) {
        if (idx == bombs.size()) {
            explode();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            arr[idx] = i;
            choose(idx + 1);
            arr[idx] = 0;
        }
    }

    static void explode() {
        exploded = new boolean[n][n];
        int area = 0;

        for (int i = 0; i < bombs.size(); i++) {
            exploded[bombs.get(i).x][bombs.get(i).y] = true;

            if (arr[i] == 1) {
                for (int j = 0; j < 4; j++) {
                    int nx = bombs.get(i).x + dx1[j];
                    int ny = bombs.get(i).y + dy1[j];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        exploded[nx][ny] = true;
                    }
                }
            } else if (arr[i] == 2) {
                for (int j = 0; j < 4; j++) {
                    int nx = bombs.get(i).x + dx2[j];
                    int ny = bombs.get(i).y + dy2[j];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        exploded[nx][ny] = true;
                    }
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    int nx = bombs.get(i).x + dx3[j];
                    int ny = bombs.get(i).y + dy3[j];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        exploded[nx][ny] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (exploded[i][j]) area++;
            }
        }

        ans = Math.max(ans, area);
    }
}