import java.util.*;

public class Main {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] num;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        jump(0, 0);

        if (ans != Integer.MAX_VALUE) {
            System.out.print(ans);
        } else {
            System.out.print(-1);
        }
    }

    static void jump(int idx, int cnt) {
        if (idx == n - 1) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (num[idx] == 0) {
            return;
        }
        for (int i = 1; i <= num[idx]; i++) {
            jump(idx + i, cnt + 1);
        }
    }
}