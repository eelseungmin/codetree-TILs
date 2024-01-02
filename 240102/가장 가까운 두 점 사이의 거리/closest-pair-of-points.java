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

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.min(ans, (seg[i][0] - seg[j][0]) * (seg[i][0] - seg[j][0]) + (seg[i][1] - seg[j][1]) * (seg[i][1] - seg[j][1]));
            }
        }

        System.out.print(ans);
    }
}