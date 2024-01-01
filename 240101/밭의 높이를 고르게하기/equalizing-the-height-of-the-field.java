import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - t; i++) {
            int cost = 0;
            for (int k = i; k < i + t; k++) {
                cost += Math.abs(h - arr[k]);
            }
            ans = Math.min(ans, cost);
        }

        System.out.print(ans);
    }
}