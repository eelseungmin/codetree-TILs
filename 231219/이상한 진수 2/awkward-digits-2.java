import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s = String.valueOf(a);
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                ch = '1';
            } else {
                ch = '0';
            }
            String tmp = "";
            tmp = s.substring(0, i) + ch + s.substring(i + 1, s.length());
            n = Math.max(n, Integer.parseInt(tmp, 2));
        }

        System.out.print(n);
    }
}