import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] people = new int[n + 1];
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = 0;
            for (int j = 0; j < n; j++) {
                dist += people[j] * ((j + n - i) % n);
            }
            min = Math.min(min, dist);
        }

        System.out.print(min);
    }
}