import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] basket = new int[101];
        for (int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int bas = sc.nextInt();
            basket[bas] += candy;
        }

        int ans = 0;
        for (int i = 0; i <= 100 - (2 * k + 1); i++) {
            int sum = 0;
            for (int j = i; j < i + 2 * k + 1; j++) {
                sum += basket[j];
            }
            ans = Math.max(sum, ans);
        }

        System.out.print(ans);
    }
}