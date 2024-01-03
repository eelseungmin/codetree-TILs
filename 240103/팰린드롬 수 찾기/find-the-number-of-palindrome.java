import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            String tmp = String.valueOf(i);
            int l = 0;
            int r = tmp.length() - 1;
            boolean palindrome = true;
            while (l < r) {
                if (tmp.charAt(l) != tmp.charAt(r)) {
                    palindrome = false;
                    break;
                }
                l++;
                r--;
            }
            if (palindrome) {
                cnt++;
            }
        }
        
        System.out.print(cnt);
    }
}