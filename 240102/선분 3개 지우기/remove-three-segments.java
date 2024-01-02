import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] seg = new int[n][101];
        for (int i = 0; i < n; i++) {
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] count = new int[101];
                    for (int h = 0; h < n; h++) {
                        if (h == i || h == j || h == k) continue;
                        for (int l = seg[h][0]; l <= seg[h][1]; l++) {
                            count[l]++;
                        }
                    }
                    boolean flag = true;
                    for (int h = 0; h <= 100; h++) {
                        if (count[h] >= 2) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) ans++;
                }
            }
        }

        System.out.print(ans);
    }
}