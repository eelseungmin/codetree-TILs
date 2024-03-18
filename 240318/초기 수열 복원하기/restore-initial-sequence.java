import java.util.*;

public class Main {
    static boolean[] vis;
    static int[] nums;
    static int[] sums;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            sums[i] = sc.nextInt();
        }

        nums = new int[n];
        vis = new boolean[n + 1];

        findComb(n, 0);
    }

    static void findComb(int n, int depth) {
        if (depth == n) {
            if (isDup(n)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(nums[i] + " ");
                    return;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                nums[i - 1] = i;
                findComb(n, depth + 1);
                nums[i - 1] = 0;
            }
        }
    }

    static boolean isDup(int n) {
        int[] tempSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            tempSums[i] = nums[i] + nums[i + 1];
        }

        Arrays.sort(tempSums);
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            if (tempSums[i] != nums[i])
                return false;
        }

        return true; 
    }
}