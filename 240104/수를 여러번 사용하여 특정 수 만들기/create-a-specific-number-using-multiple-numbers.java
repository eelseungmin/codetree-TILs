import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i * a <= c; i++) {
            int cnt = a * i;

            int numb = (c - cnt) / b;

            cnt += numb * b;

            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}