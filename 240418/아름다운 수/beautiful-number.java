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
        for (int i = 0; i < n; i += arr[i]) {
            if (i + arr[i] - 1 >= n)
                return false;
        
            for (int j = i; j < i + arr[i]; j++) {
                if (arr[j] != arr[i])
                    return false;
            }
        }

        return true;
    }
}