import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = 0;
        int b = 0 ;
        char[] c = new char[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.next().charAt(0);
            s[i] = sc.nextInt();
        }

        char win = '\u0000';
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'A') {
                a += s[i];
            } else {
                b += s[i];
            }

            if (a > b) {
                if (win == '\u0000') {
                    win = 'a';
                    ans++;
                } else if (win == 'b') {
                    win = 'a';
                    ans++;
                } 
            } else if (a < b) {
                if (win == '\u0000') {
                    win = 'b';
                    ans++;
                } else if (win == 'a') {
                    win = 'b';
                    ans++;
                }
            } else {
                if (win != '\u0000') {
                    win = '\u0000';
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}