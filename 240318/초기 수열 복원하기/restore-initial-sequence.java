import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            sums[i] = sc.nextInt();
        }

        int[] arr = new int[n];
        // 1000!이므로 단순 완전탐색은 x
        // 수열의 초항이 정해지면 나머지 항은 정해진다.
        for (int i = 1; i <= n; i++) {
            arr[0] = i;

            for (int j = 1; j < n; j++) {
                // sums[i] == arr[i] + arr[i + 1]
                arr[j] = sums[j - 1] - arr[j - 1];
            }

            boolean satis = true;
            boolean[] isUsed = new boolean[1001];
            for (int j = 0; j < n; j++) {
                if (arr[j] <= 0 || arr[j] > n) {
                    satis = false;
                } else {
                    if (isUsed[arr[j]]) {
                        satis = false;
                    }
                    isUsed[arr[j]] = true;
                }
            }
            if (!satis) continue;
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
        }
    }
}