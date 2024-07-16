import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Info {
    char d;
    int p;

    Info(char d, int p) {
        this.d = d;
        this.p = p;
    }
}

public class Main {
    static int n, m, k, time;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static Info[] info;
    // 머리부터 꼬리가 이어진 몸통이 필요하므로 리스트로 관리
    // 머리를 제외한 나머지 부위는 앞에서부터 차례대로 바로 앞 원소의 위치로 이동하면 된다.
    static List<Point> snake = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new int[n + 1][n + 1];
        info = new Info[k];
        snake.add(new Point(1, 1));
        for (int i = 0; i < m; i++) {
            map[sc.nextInt()][sc.nextInt()] = 1;
        }
        for (int i = 0; i < k; i++) {
            info[i] = new Info(sc.next().charAt(0), sc.nextInt());
        }

        for (int i = 0; i < k; i++) {
            char ch = info[i].d;
            boolean exit = false;
            if (ch == 'U') {
                exit = simulation(info[i].p, 0);
            } else if (ch == 'D') {
                exit = simulation(info[i].p, 1);
            } else if (ch == 'R') {
                exit = simulation(info[i].p, 2);
            } else {
                exit = simulation(info[i].p, 3);
            }
            if (!exit) {
                time++;
                break;
            }
        }

        System.out.print(time);
    }

    static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    static boolean isOverlap() {
        int hx = snake.get(0).x;
        int hy = snake.get(0).y; 
        for (int i = 1; i < snake.size(); i++) {
            if (hx == snake.get(i).x && hy == snake.get(i).y) {
                return true;
            }
        }

        return false;
    }

    static boolean simulation(int count, int dir) {
        boolean apple = false;

        while (count-- > 0) {
            int nx = snake.get(0).x + dx[dir];
            int ny = snake.get(0).y + dy[dir];
            // 격자 안인지 확인
            if (!inRange(nx, ny)) return false;
            // 사과가 있는지 확인
            if (map[nx][ny] == 1) {
                apple = true;
                map[nx][ny] = 0;
            }
            // 머리 이동
            int lastx = snake.get(0).x;
            int lasty = snake.get(0).y;
            snake.get(0).x = nx;
            snake.get(0).y = ny;
            // System.out.println(nx + " " + ny);
            int tmpx = 0;
            int tmpy = 0;
            // 나머지 부위 이동
            for (int j = 1; j < snake.size(); j++) {
                tmpx = snake.get(j).x;
                tmpy = snake.get(j).y;
                snake.get(j).x = lastx;
                snake.get(j).y = lasty;
                lastx = tmpx;
                lasty = tmpy;
            }
            // 사과를 먹었으면 꼬리를 늘린다.
            if (apple) snake.add(new Point(lastx, lasty));
            // 머리가 다른 부위랑 하나라도 겹치는지 확인
            if (isOverlap()) return false;
            time++;
        }

        return true;
    }
}