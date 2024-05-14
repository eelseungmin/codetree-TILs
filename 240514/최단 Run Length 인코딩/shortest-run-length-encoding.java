import java.util.*;

public class Main {
    static String a;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a = sc.next();

        for (int i = 1; i < a.length(); i++) {
            String res = encoding(shift(i));
            if (res.length() > 0)
                ans = Math.min(ans, res.length());
        }

        System.out.print(ans);
    }

    static String shift(int cnt) {
        String prefix = "";
        for (int i = 1; i <= cnt; i++) {
            prefix += a.charAt(a.length() - i);
        }
        
        return prefix + a.substring(0, a.length() - prefix.length());
    }

    static String encoding(String str) {
        String res = "";
        char before = str.charAt(0);
        int cnt = 1;

        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (before != cur) {
                res += before;
                res += String.valueOf(cnt);

                before = cur;
                cnt = 1;
            }
        }
        res += before;
        res += String.valueOf(cnt);

        return res;
    }
}