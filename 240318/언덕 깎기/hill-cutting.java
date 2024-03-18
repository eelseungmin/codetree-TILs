import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] hill = new int[n];
        int minh = 101;
        int maxh = -1;
        for (int i = 0; i < n; i++) {
            hill[i] = sc.nextInt();
            minh = Math.min(minh, hill[i]);
            maxh = Math.max(maxh, hill[i]);
        }

        int cost = Integer.MAX_VALUE;
        for (int x = 0; x <= 100 - minh; x++) {
            if (maxh - (minh + x) <= 17) {
                cost = Math.min(cost, x * x);
            }
            for (int y = 0; y <= maxh; y++) {
                if ((maxh - y) - (minh + x) <= 17) {
                    cost = Math.min(cost, x * x + y * y);
                }
            }
        }

        System.out.print(cost);
    }
}