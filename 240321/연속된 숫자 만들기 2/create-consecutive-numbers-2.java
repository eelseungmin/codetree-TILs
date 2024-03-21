import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        // 2 6 9  2
        // 2 9 6  
        // 6 2 9
        // 6 9 2
        // 9 2 6
        // 9 6 2

        // 2 3 9
        // 3 5 9
        // 차이가 1일땐 2회
        // 차이가 2일땐 1회
        // 차이가 3이상이면 2회
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        
        int diff1 = Math.abs(x - y);
        int diff2 = Math.abs(y - z);

        int ans = 0;
        if (diff1 == 2 || diff2 == 2) {
            ans = 1;
        } else if (diff1 == 1 && diff2 == 1) {
            ans = 0;
        } else {
            ans = 2;
        }

        System.out.print(ans);
    }
}