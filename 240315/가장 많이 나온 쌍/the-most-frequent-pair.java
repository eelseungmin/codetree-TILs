import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ab = new int[m][m];
        for (int i = 0; i < m; i++) {
            ab[i][0] = sc.nextInt();
            ab[i][1] = sc.nextInt();
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    if (ab[k][0] == i && ab[k][1] == j || ab[k][1] == i && ab[k][0] == j) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }

        System.out.print(ans);
    }
}