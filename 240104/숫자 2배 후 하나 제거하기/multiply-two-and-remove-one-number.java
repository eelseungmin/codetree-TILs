import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == j) tmp[j] = arr[j] * 2;
                else tmp[j] = arr[j];
            }

            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    else list.add(tmp[k]);
                }

                int sum = 0;
                for (int k = 1; k < n - 1; k++) {
                    sum += Math.abs(list.get(k - 1) - list.get(k));
                }

                ans = Math.min(ans, sum);
            }
        }

        System.out.print(ans);
    }
}