import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] vis;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        vis = new boolean[n + 1];

        choose(0);
    }

    static void choose(int idx) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = n; i >= 1; i--) {
            if (!vis[i]) {
                arr[idx] = i;
                vis[i] = true;
                choose(idx + 1);
                vis[i] = false;
            }
        }
    }
}