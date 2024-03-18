import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] hill = new int[n];
        for (int i = 0; i < n; i++) {
            hill[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if (hill[j] < i) {
                    cost += (hill[j] - i) * (hill[j] - i);
                }   
                if (hill[j] > i + 17) {
                    cost += (hill[j] - i - 17) * (hill[j] - i - 17);
                }
            }
            ans = Math.min(ans, cost);
        }

        System.out.print(ans);
    }
}