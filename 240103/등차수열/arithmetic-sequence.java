import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            int cnt = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] < i && i < nums[k]) {
                        if (i - nums[j] == nums[k] - i) {
                            cnt++;
                        }
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}