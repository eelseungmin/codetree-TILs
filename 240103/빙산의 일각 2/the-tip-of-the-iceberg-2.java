import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i <= 1000; i++) {
            int cnt = 0;
            for (int j = 1; j < n; j++) {
                if (height[j - 1] > i && height[j] <= i) {
                    cnt++;
                }
            }
            if (height[n - 1] > i) {
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}