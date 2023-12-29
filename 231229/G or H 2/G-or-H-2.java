import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] pos = new char[101];
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            pos[idx] = sc.next().charAt(0);
        }

        int ans = -1;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                if (pos[i] == '\u0000' || pos[j] == '\u0000') continue;
                int G = 0;
                int H = 0;
                for (int k = i; k <= j; k++) {
                    if (pos[k] == 'G') G++;
                    if (pos[k] == 'H') H++;
                }
                if (G == j - i + 1 || H == j - i + 1 || G == H) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        System.out.print(ans);
    }
}