import java.util.*;

public class Main {
    static int[][] seg;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxX = 0;
            int minX = 40001;
            int maxY = 0;
            int minY = 40001;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                maxX = Math.max(maxX, seg[j][0]);
                maxY = Math.max(maxY, seg[j][1]);
                minX = Math.min(minX, seg[j][0]);
                minY = Math.min(minY, seg[j][1]);
            }

            ans = Math.min(ans, (maxX - minX) * (maxY - minY));
        }

        System.out.print(ans);
    }
}