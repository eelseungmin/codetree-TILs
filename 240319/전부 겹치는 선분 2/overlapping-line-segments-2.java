import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }


        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int maxx1 = -1;
            int minx2 = 101;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                maxx1 = Math.max(maxx1, x1[i]);
                minx2 = Math.min(minx2, x2[j]);
            }
            if (minx2 >= maxx1) {
                flag = true;
            }
        }

        if (flag) {
            System.out.print("Yes");
            return;
        }
        System.out.print("No");
    }
}