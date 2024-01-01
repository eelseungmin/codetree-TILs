import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] dev = new int[6];
        for (int i = 0; i < 6; i++) {
            dev[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    ans = Math.min(ans, calcDiff(dev, i, j, k));
                }
            }
        }

        System.out.print(ans);
    }

    public static int calcDiff(int[] arr, int i, int j, int k) {
        int sum1 = arr[i] + arr[j] + arr[k];
        int sum2 = 0;
        for (int a = 0; a < 6; i++) {
            sum2 += arr[a];
        }
        sum2 -= sum1;

        System.out.println(i + " " + j + " " + k);
        return Math.abs(sum1 - sum2);
    }
}