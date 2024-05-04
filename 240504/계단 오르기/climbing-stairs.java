import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[2] = 1; // 2
        dp[3] = 1; // 3
        dp[4] = 1; // 2 2
        dp[5] = 2; // 2 3  3 2
        dp[6] = 2; // 2 2 2  3 3
        dp[7] = 3; // 2 2 3  2 3 2  3 2 2
        dp[8] = 5; // 2 2 2 2  2 3 3  3 2 3  3 3 2
        for (int i = 6; i < 1001; i++) {
           dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
        }

        System.out.print(dp[n] % 10007);
    }
}