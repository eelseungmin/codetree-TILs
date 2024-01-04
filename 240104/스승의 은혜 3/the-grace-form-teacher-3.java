import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int ans = 0;
        // 할인할 선물 선택
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == j) tmp[j] = p[j] / 2 + s[j];
                else tmp[j] = p[j] + s[j];
            }
            Arrays.sort(tmp);

            int budget = 0;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                budget += tmp[j];

                if (budget <= b) cnt++;
                else break;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}