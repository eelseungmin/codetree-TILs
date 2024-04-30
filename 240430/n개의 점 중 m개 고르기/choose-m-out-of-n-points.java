import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static Pair[] arr;
    static Pair[] pairs;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pairs = new Pair[n];
        arr = new Pair[m];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        choose(0, -1);

        System.out.print(ans);
    }

    static void choose(int idx, int last) {
        if (idx == m) {
            ans = Math.min(ans, calc());
            return;
        }

        for (int i = last + 1; i < n; i++) {
            arr[idx] = pairs[i];
            choose(idx + 1, i);
        }
    }

    static int calc() {
        int dist = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                dist = Math.max(
                    dist, 
                    (arr[i].x - arr[j].x) * (arr[i].x - arr[j].x) + 
                    (arr[i].y - arr[j].y) * (arr[i].y - arr[j].y)
                );
            }
        }

        return dist;
    }
}