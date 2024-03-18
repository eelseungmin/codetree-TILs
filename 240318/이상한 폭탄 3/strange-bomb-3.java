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

        boolean[] exploded = new boolean[n];
        for (int i = 0; i < n - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (bomb[i] == bomb[j]) {
                    exploded[i] = true;
                    exploded[j] = true;
                }
            }
        }

        int[] cnt = new int[1000001];
        for (int i = 0; i < n; i++) {
            if (exploded[i]) {
                cnt[bomb[i]]++;
            }
        }
        
        int maxNum = 0;
        int maxVal = 0;
        for (int i = 0; i <= n; i++) {
            if (maxVal < cnt[i]) {
                maxVal = cnt[i];
                maxNum = i;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (maxVal == cnt[i]) {
                maxNum = Math.max(maxNum, i);
            }
        }

        System.out.print(maxNum);
    }
}