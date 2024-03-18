import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 10000; i++) {
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < i) {
                    cost += Math.abs(arr[j] - i);
                }
                if (arr[j] > i + k) {
                    cost += Math.abs(arr[j] - i - k);
                }
            }
            ans = Math.min(ans, cost);
        }

        System.out.print(ans);
    }
}