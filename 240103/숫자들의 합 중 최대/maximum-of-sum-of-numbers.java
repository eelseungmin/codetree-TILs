import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int ans = 0;
        for (int i = x; i <= y; i++) {
            int tmp = i;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            
            ans = Math.max(ans, sum);
        }   

        System.out.print(ans);
    }
}