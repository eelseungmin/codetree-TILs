import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] b = new String[n];
        int[] one = new int[n];
        int[] two = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = String.valueOf(sc.nextInt());
            one[i] = sc.nextInt();
            two[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || k == i) continue;
                    int cnt = 0;
                    for (int h = 0; h < n; h++) {
                        int on = 0;
                        int tw = 0;
                        for (int l = 0; l < 3; l++) {
                           int ch = b[h].charAt(l) - '0';
                           if ((ch == i && l == 0) || (ch == j && l == 1) || (ch == k && l == 2)) on++;
                           if ((ch == i && l != 0) || (ch == j && l != 1) || (ch == k && l != 2)) tw++;
                        }
                        if (one[h] == on && two[h] == tw) cnt++;
                    }
                    if (cnt == n) {
                        ans++;
                    }
                }   
            }
        }

        System.out.print(ans);
    }
}