import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[n];

        for (int i = 0; i < n; i++) {
            cnt[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cnt[i];
        }

        int average = sum / n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > average) {
                ans += Math.abs(average - cnt[i]);
            }
        }

        System.out.print(ans);
    }
}