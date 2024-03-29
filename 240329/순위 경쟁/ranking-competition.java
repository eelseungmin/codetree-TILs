import java.util.*;

public class Main {
    static char[] c;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        c = new char[n];
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = sc.next().charAt(0);
            s[i] = sc.nextInt();
        }

        int aa = 0;
        int bb = 0;
        int cc = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'A') {
                if (status(aa, bb, cc) != status(aa + s[i], bb, cc)) {
                    ans++;
                }

                aa += s[i];
            } else if (c[i] == 'B') {
                if (status(aa, bb, cc) != status(aa, bb + s[i], cc)) {
                    ans++;
                }

                bb += s[i];
            } else {
                if (status(aa, bb, cc) != status(aa, bb, cc + s[i])) {
                    ans++;
                }

                cc += s[i];
            }
        }

        System.out.print(ans);
    }

    public static int status(int score1, int score2, int score3) {
        int status = 0;

        int max = Math.max(score1, score2);
        max = Math.max(max, score3);

        if (score1 == max) {
            status += 1;
        }

        if (score2 == max) {
            status += 2;
        }

        if (score3 == max) {
            status += 4;
        }

        return status;
    }
}