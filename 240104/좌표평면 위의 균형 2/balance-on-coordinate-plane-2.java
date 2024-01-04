import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i % 2 != 0 || j % 2 != 0) continue;

                // 4분할
                int one = 0;
                int two = 0;
                int three = 0;
                int four = 0;
                for (int k = 0; k < n; k++) {
                    if (x[k] < i && y[k] > j) {
                        one++;
                    } else if (x[k] > i && y[k] > j) {
                        two++;
                    } else if (x[k] < i && y[k] < j) {
                        three++;
                    } else {
                        four++;
                    }
                }

                int big = 0;
                big = Math.max(one, two);
                big = Math.max(big, three);
                big = Math.max(big, four);

                ans = Math.min(ans, big);
            }
        }

        System.out.print(ans);
    }
}