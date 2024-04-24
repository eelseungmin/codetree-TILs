import java.util.*;

class Pair {
    int x, y;

    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /**
    백트래킹으로 모든 경우를 시행해본 뒤 최댓값 갱신
    */
    static int n, r, c, ans;
    static int[][] num;
    static int[][] dir;
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        dir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dir[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt();
        c = sc.nextInt();

        simulation(r - 1, c - 1, 0);

        System.out.print(ans);
    }

    static void simulation(int x, int y, int cnt) {
        ans = Math.max(ans, cnt); 

        List<Pair> list = new ArrayList<>();
        int a = x;
        int b = y;
        while (true) {
            a += dx[dir[x][y]];
            b += dy[dir[x][y]];
            if (!inRange(a, b)) {
                break;
            }
            if (num[a][b] > num[x][y]) {
                list.add(new Pair(a, b));
            }
        }


        for (int i = 0; i < list.size(); i++) {
            simulation(list.get(i).x, list.get(i).y, cnt + 1);
        }
    }

    static boolean inRange(int nx, int ny) {
        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
            return true;
        }
        return false;
    }
}