import java.util.*;

public class Main {
    public static int[] dev;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        dev = new int[6];
        for (int i = 0; i < 6; i++) {
            dev[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    ans = Math.min(ans, calcDiff(i, j, k));
                }
            }
        }

        System.out.print(ans);
    }

    public static int calcDiff(int i, int j, int k) {
        int sum1 = dev[i] + dev[j] + dev[k];
        int sum2 = 0;
        for (int a = 0; a < 6; a++) {
            sum2 += dev[a];
        }
        sum2 -= sum1;

        return Math.abs(sum1 - sum2);
    }
}