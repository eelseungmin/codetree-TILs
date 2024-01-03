import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[] pos = new char[1001];
        for (int i = 0; i < T; i++) {
            char ch = sc.next().charAt(0);
            pos[sc.nextInt()] = ch;
        }

        int ans = 0;
        for (int i = a; i <= b; i++) {
            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;
            for (int j = 1; j <= 1000; j++) {
                if (pos[j] == 'S') {
                    d1 = Math.min(d1, Math.abs(j - i));
                } else if (pos[j] == 'N') {
                    d2 = Math.min(d2, Math.abs(j - i));
                }
            }
            if (d1 <= d2) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}