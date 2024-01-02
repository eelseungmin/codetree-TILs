import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bomb = new int[n];
        for (int i = 0; i < n; i++) {
            bomb[i] = sc.nextInt();
        }

        int max = -1;
        // 0 1 2 3 4 5
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i <= k && bomb[i] == bomb[j]) {
                    max = Math.max(max, bomb[j]);
                }
            }
        }

        System.out.print(max);
    }
}