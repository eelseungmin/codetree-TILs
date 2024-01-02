import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] res = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int h = 0; h < k; h++) {
                    int left = -1;
                    int right = -1;
                    for (int v = 0; v < n; v++) {
                        if (res[h][v] == i) left = v;
                        if (res[h][v] == j) right = v;
                    }
                    if (left < right) cnt++;
                }
                if (cnt == k) ans++;
            }
        }

        System.out.print(ans);
    }
}