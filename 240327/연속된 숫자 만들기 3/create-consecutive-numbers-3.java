import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 1 5 9
        // 둘다 1이면 0
        // 둘중 하나만 1이고 하나는 2인 경우 1
        // 1 3 4 
        // 둘중 하나만 1이고 하나는 3인 경우 2
        // 둘중 하나만 1이고 하나는 4인 경우 3
        // 4
        // 둘다 2인 경우 1
        // 둘 중 하나는 2이고 하나는 3인 경우 2
        // 1 3 6
        // 3 4 6
        // 4 5 6 3

        // 둘 중 하나는 2이고 하나는 4인 경우 3
        // 1 3 7
        // 3 4 7
        // 4 5 7
        // 5 6 7
        // 1 4 7
        // 4 5 7
        // 5 6 7

        // 1 4 10000
        // 4 5 10000

        int diff1 = Math.abs(a - b);
        int diff2 = Math.abs(b - c);
        int ans = -1;
        if (diff1 == 1 && diff2 == 1) {
            ans = 0;
        } else {
            ans = Math.max(diff1, diff2) - 1;
        }

        System.out.print(ans);
    }
}