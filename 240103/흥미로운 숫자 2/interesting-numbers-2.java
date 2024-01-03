import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int ans = 0;
        for (int i = x; i <= y; i++) {
            int tmp = i;
            int[] count = new int[10];
            while (tmp > 0) {
                count[tmp % 10]++;
                tmp /= 10;
            }
            int one = 0;
            int other = 0;
            for (int j = 0; j < 10; j++) {
                if (count[j] == 1) {
                    one++;
                } else if (count[j] != 0) {
                    other++;
                }
            }
            if (one == 1 && other == 1) ans++;
        }

        System.out.print(ans);
    }
}