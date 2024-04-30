import java.util.*;

public class Main {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] num;
    static boolean[] vis;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        /**
        조합을 만들고 선택되지 않은 그룹과 선택된 그룹을 나눈 후 계산
        */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n * 2];
        vis = new boolean[n * 2];
        for (int i = 0; i < n * 2; i++) {
            num[i] = sc.nextInt();
        }

        choose(0, -1);
        
        System.out.print(ans);
    }

    static void choose(int idx, int last) {
        if (idx == n) {
            ans = Math.min(ans, calc());
            return;
        }

        for (int i = last + 1; i < 2 * n; i++) {
            vis[i] = true;
            choose(idx + 1, i);
            vis[i] = false;
        }
    }
    
    static int calc() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (vis[i]) {
                sum1 += num[i];
            } else {
                sum2 += num[i];
            }
        }

        return Math.abs(sum1 - sum2);
    }
}