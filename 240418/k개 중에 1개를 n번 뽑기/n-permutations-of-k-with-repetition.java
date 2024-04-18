import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] vis;
    static int n, k;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        vis = new boolean[n];

        choose(0);
    }

    static void choose(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            vis[depth] = true;
            arr[depth] = i;
            choose(depth + 1);
            vis[depth] = false;
        }
    }
}