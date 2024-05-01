import java.util.*;

public class Main {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] vis;
    static int[] arr;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n + 1][n + 1];
        vis = new boolean[n + 1];
        arr = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        choose(0);

        System.out.print(ans);
    }

    static void choose(int idx) {
        if (idx == n) {
            ans = Math.min(ans, calc());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                arr[idx] = i;
                vis[i] = true;
                if (arr[0] == 1)
                    choose(idx + 1);
                vis[i] = false;
            }
        }
    }

    static int calc() {
        int sum = 0;

        for (int i = 0; i < n - 1; i++){
            if (cost[arr[i]][arr[i + 1]] == 0)
                return Integer.MAX_VALUE;
            // System.out.print(arr[i] + "->" + arr[i + 1] + ":" + cost[arr[i]][arr[i + 1]] + " ");
            sum += cost[arr[i]][arr[i + 1]];  
        }

        if (cost[arr[n - 1]][1] == 0) {
            return Integer.MAX_VALUE;
        }
        sum += cost[arr[n - 1]][1];
        // System.out.println("sum: " + sum);

        return sum;
    }
}