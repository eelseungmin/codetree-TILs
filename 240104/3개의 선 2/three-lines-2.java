import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.enxtInt();
        }

        int ans = 0;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {

                    // x축에 평행한 직선 3개
                    boolean success = true;
                    for (int l = 0; l < n; l++) {
                        if (seg[l][1] == i || seg[l][1] == j || seg[l][1] == k) continue;

                        success = false;
                    }
                    if (success) ans = 1;

                    // x축에 평행한 직선 2개, y축에 평행한 직선 1개
                    boolean success = true;
                    for (int l = 0; l < n; l++) {
                        if (seg[l][1] == i || seg[l][1] == j || seg[l][0] == k) continue;

                        success = false;
                    }
                    if (success) ans = 1;

                    // x축에 평행한 직선 1개, y축에 평행한 직선 2개
                    boolean success = true;
                    for (int l = 0; l < n; l++) {
                        if (seg[l][1] == i || seg[l][0] == j || seg[l][0] == k) continue;

                        success = false;
                    }
                    if (success) ans = 1;

                    // y축에 평행한 직선 3개
                    boolean success = true;
                    for (int l = 0; l < n; l++) {
                        if (seg[l][0] == i || seg[l][0] == j || seg[l][0] == k) continue;

                        success = false;
                    }
                    if (success) ans = 1;
                }
            }
        }

        System.out.print(ans);
    }
}