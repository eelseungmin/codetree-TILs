import java.util.*;

class Pair implements Comparable<Pair> {
    int x, y;
    char val;

    Pair(int x, int y, char val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Pair p) {
        return this.val - p.val;
    }
}

public class Main {
    static int n, ans;
    static Pair s, e;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Pair> list = new ArrayList<>();
    static List<Pair> selected = new ArrayList();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        /**
        숫자들을 이용해서 조합을 구한다.
        구해진 조합을 이용해서 시작점으로부터 끝점까지 차례대로 bfs를 수행하고 구해진 거리를 모두 더해 최솟값 갱신
        */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'S') {
                    s = new Pair(i, j, 'S');
                } else if (map[i][j] == 'E') {
                    e = new Pair(i, j, 'E');
                } else if (map[i][j] == '.') {
                    continue;
                } else {
                    list.add(new Pair(i, j, map[i][j]));
                }
            }
        }
        Collections.sort(list);
        choose(0, -1);

        if (ans == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(ans);
        }
    }

    static void choose(int idx, int last) {
        if (idx == 3) {
            int dist = 0;

            for (int i = 0; i < selected.size() - 1; i++) {
                dist += bfs(selected.get(i), selected.get(i + 1));
            }
            dist += bfs(s, selected.get(0));
            dist += bfs(selected.get(selected.size() - 1), e);

            ans = Math.min(ans, dist);
            return;
        }

        for (int i = last + 1; i < list.size(); i++) {
            selected.add(list.get(i));
            choose(idx + 1, i);
            selected.remove(selected.size() - 1);
        }
    }
    
    static int bfs(Pair start, Pair end) {
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[start.x][start.y] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.offer(new Pair(nx, ny, map[nx][ny]));
                }
            }
        }

        return dist[end.x][end.y];
    }
}