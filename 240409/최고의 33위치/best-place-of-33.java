import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i + 2 >= n)
                continue;
            for (int j = 0; j < n; j++) {
                if (j + 2 >= n)
                    continue;
                
                int cnt = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int h = j; h < j + 3; h++) {
                        if (map[k][h] == 1)
                            cnt++;
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }

        System.out.print(ans);
    }
}