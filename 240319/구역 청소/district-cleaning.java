import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] cnt = new int[101];
        for (int i = a; i <= b; i++) {
            cnt[i]++;
        }
        for (int i = c; i <= d; i++) {
            cnt[i]++;
        }
        int dup = 0;
        for (int i = 0; i <= 100; i++) {
            if (cnt[i] > 1)
                dup++;
        }

        if (dup > 0) System.out.print(b - a + d - c - dup + 1);
        else System.out.print(b - a + d - c);
    }
}