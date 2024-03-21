import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        // a -> b
        // a -> x -> y -> b
        // a -> y -> x -> b
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, Math.abs(b - a));
        ans = Math.min(ans, Math.abs(a - x) + Math.abs(b - y));
        ans = Math.min(ans, Math.abs(a - y) + Math.abs(b - x));

        System.out.print(ans);
    }
}