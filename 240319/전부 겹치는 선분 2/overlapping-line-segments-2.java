import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minx2 = 101;
        int maxx1 = -1;
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            minx2 = Math.min(minx2, x2);
            maxx1 = Math.max(maxx1, x1);
        }

        if (maxx1 > minx2) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}