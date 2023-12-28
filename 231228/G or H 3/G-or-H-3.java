import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() + 1;
        char[] arr = new char[10001];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()] = sc.next().charAt(0);
        }

        int ans = 0;
        for (int i = 1; i <= 10000 - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] == 'G') sum += 1;
                if (arr[j] == 'H') sum += 2;
            }
            ans = Math.max(ans, sum);
        }

        System.out.print(ans);
    }
}