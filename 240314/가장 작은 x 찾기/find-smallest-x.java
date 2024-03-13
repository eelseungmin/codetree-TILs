import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int k = 0; k < n; k++) {
            a[k] = sc.nextInt();
            b[k] = sc.nextInt();
        }
        for (int i = 1; i <= 10000; i++) {
            int num = i;

            boolean pass = true;
            for (int j = 0; j < n; j++) {
                num *= 2;
                if (num >= a[j] && num <= b[j]) continue;
                else pass = false;
            }
            
            if (pass) {
                System.out.print(i);
                return;
            }
        }
    }
}