import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();
        }

        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || k == i) continue;
                    if (seg[i][0] != seg[j][0] && seg[j][0] != seg[k][0] && seg[k][0] != seg[i][0]) continue;
                    if (seg[i][1] != seg[j][1] && seg[j][1] != seg[k][1] && seg[k][1] != seg[i][1]) continue;
                    max = Math.max(max, (double) Math.abs((seg[i][0] * seg[j][1] + seg[j][0] * seg[k][1] + seg[k][0] * seg[i][1]) - (seg[j][0] * seg[i][1] + seg[k][0] * seg[j][1] + seg[i][0] * seg[k][1])) / 2.0);
                }
            }
        }

        System.out.print((int) max * 2);
    }
}