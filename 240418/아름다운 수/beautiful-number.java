import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int ans;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        choose(0);

        System.out.print(ans);
    }

    static void choose(int idx) {
        if (idx == n) {
            if (check()) ans++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[idx] = i;
            choose(idx + 1);
            arr[idx] = 0;
        }
    }

    static boolean check() {
        int p = 0;
        int cnt = 0;
        int target = 0;
        
        while (p < n) {
            if (cnt == 0) {
                cnt = arr[p];
                target = arr[p];
            }

            while (cnt-- > 0) {
                if (p >= n) {
                    return false;
                }

                if (arr[p] != target) {
                    return false;
                }

                p++;
            }
        }

        return true;
    }
}