import java.util.*;

class Pair {
    int a, b, c;

    Pair(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    static int n, m, ans;
    static Pair[] rows;
    static List<Pair> list = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        rows = new Pair[m];
        result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            rows[i] = new Pair(a, a + 1, b);
        }
        ans = Integer.MAX_VALUE;

        sadariWithAll();
        // System.out.println("result: " + Arrays.toString(result));
        choose(0);

        System.out.print(ans);
    }

    static void choose(int idx) {
        if (idx == m) {
            if (sadari()) {
                ans = Math.min(ans, list.size());
            }
            return;
        }

        list.add(rows[idx]);
        choose(idx + 1);
        list.remove(list.size() - 1);
        choose(idx + 1);
    }

    // 모든 가로줄 이용 시
    static void sadariWithAll() {
        int col = -1;
        // 사람 선택
        for (int i = 1; i <= n; i++) {
            col = i;
            // 현재 행 갱신
            for (int row = 1; row <= 15; row++) {
                // 행과 일치하는 가로줄 탐색
                for (int j = 0; j < rows.length; j++) {
                    // 열과 일치하는지 확인 후 위치 갱신
                    if (rows[j].c == row) {
                        if (rows[j].a == col) {
                            col = rows[j].b;
                        } else if (rows[j].b == col) {
                            col = rows[j].a;
                        }
                    }
                }
            }
            result[col] = i;
        }
    }

    // 조합으로 뽑힌 가로줄만 이용 시
    static boolean sadari() {
        int[] curResult = new int[n + 1];

        int col = -1;
        for (int i = 1; i <= n; i++) {
            col = i;
            for (int row = 1; row <= 15; row++) {
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k).c == row) {
                        if (list.get(k).a == col) {
                            col = list.get(k).b;
                        } else if (list.get(k).b == col) {
                            col = list.get(k).a;
                        }
                    }
                }
            }
            curResult[col] = i;
        }

        // System.out.println("curResult: " + Arrays.toString(curResult));

        // 모든 가로줄을 이용한 경우와 비교
        for (int i = 1; i <= n; i++) {
            if (result[i] != curResult[i])
                return false;
        }

        return true;
    }
}