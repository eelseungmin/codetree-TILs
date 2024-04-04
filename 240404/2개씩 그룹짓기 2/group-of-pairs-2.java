import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2 5 7 9 10 15
        // 최솟값이 최대
        // 7 5 
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, arr[i + n] - arr[i]);
        }

        System.out.print(ans);
    }
}