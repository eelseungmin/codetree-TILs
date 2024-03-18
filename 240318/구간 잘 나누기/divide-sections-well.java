import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 단순히 완전탐색하기엔 99C50이라 안된다.
        // 구간의 합의 최댓값을 설정하면 된다.
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 10000; i++) {

            int cnt = 0; // 구간 갯수
            int sum = 0; // 구간합
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] > i) {
                    flag = false;
                    break;
                }

                if (arr[j] + sum > i) {
                    sum = 0;
                    cnt++;
                }

                sum += arr[j];
            }
            if (flag && cnt <= m - 1) {
                ans = Math.min(ans, i);
            }
        }

        System.out.print(ans);
    }
}