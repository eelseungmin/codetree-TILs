import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        Arrays.sort(price);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int total = b;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j && total - price[j] / 2 >= 0) {
                    total -= price[j] / 2;
                    cnt++;
                } else if (total - price[j] >= 0) {
                    total -= price[j];
                    cnt++;
                } else {
                    break;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}