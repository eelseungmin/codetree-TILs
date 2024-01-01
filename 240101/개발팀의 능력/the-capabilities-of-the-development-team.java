import java.util.*;

public class Main {
    static int[] dev;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        dev = new int[5];
        for (int i = 0; i < 5; i++) { 
            dev[i] = sc.nextInt();
        }
        
        int ans = 1000000;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int h = 0; h < 5; h++) {
                    for (int k = h + 1; k < 5; k++) {
                        if (i == h || i == k || j == h || j == k) continue;
                        ans = Math.min(ans, getDiff(i, j, k, h));
                    }
                }
            }
        }
        
        if (ans == 1000000) System.out.print(-1);
        else System.out.print(ans);
    }

    public static int getDiff(int i, int j, int k, int h) {
        int sum1 = dev[i] + dev[j];
        int sum2 = dev[k] + dev[h];
        int sum3 = 0;
        for (int a = 0; a < 5; a++) {
            sum3 += dev[a];
        }
        sum3 -= sum1;
        sum3 -= sum2;

        if (sum1 == sum2 || sum2 == sum3 || sum3 == sum1) return 1000000;

        int max = Math.max(Math.max(sum1, sum2), sum3);
        int min = Math.min(Math.min(sum1, sum2), sum3);

        return Math.abs(max - min);
    }
}