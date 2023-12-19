import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int val = 0;
            for (int j = 1; j <= n; j++) {
                val += Math.abs(j - i) * arr[j];
            }
            min = Math.min(min, val);
        }

        System.out.print(min);
    }
}