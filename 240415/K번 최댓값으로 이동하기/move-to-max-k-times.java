import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.x == p.x) {
            return this.y - p.y;
        }
        return this.x - p.x;
    }
}

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int n, k, r, c;
    static Queue<Pair> q = new LinkedList<>();
    static Stack<Pair> st = new Stack<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt();
        c = sc.nextInt();

        bfs(r - 1, c - 1);
    }

    static void bfs(int x, int y) {
        q.offer(new Pair(x, y));
        st.push(new Pair(x, y));

        while (k-- > 0) {
            Pair cur = q.poll();
            
            if (!check(cur)) {
                break;
            }
        }

        Pair last = st.pop();
        System.out.print((last.x + 1) + " " + (last.y + 1));
    }

    static boolean check(Pair cur) {
        int maxVal = -1;
        List<Pair> maxPairs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[nx][ny] < map[cur.x][cur.y]) {
                    maxVal = Math.max(maxVal, map[nx][ny]);
                }
            }
        }

        if (maxVal == -1) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[nx][ny] == maxVal) {
                    maxPairs.add(new Pair(nx, ny));
                }
            }
        }

        if (maxPairs.size() == 1) {
            q.offer(maxPairs.get(0));
            st.push(maxPairs.get(0));
            return true;
        }

        Collections.sort(maxPairs);
        q.offer(maxPairs.get(0));
        st.push(maxPairs.get(0));
        return true;
    }   
}