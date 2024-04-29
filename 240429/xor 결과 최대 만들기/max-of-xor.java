import java.util.*;

public class Main {
    static int n, m, ans;
    static int[] num;
    static int[] selected;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        selected = new int[m];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        choose(0, -1);

        System.out.print(ans);
    }

    static void choose(int idx, int lastIdx) {
        if (idx == m) {
            int res = selected[0];
            for (int i = 1; i < m; i++) {
                res = res ^ selected[i];
            }
            ans = Math.max(ans, res);
            return;
        }

        for (int i = lastIdx + 1; i < n; i++) {
            selected[idx] = num[i];
            choose(idx + 1, i);
        }
    }
}