import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (str[i] == '0') {
                str[i] = '1';
                ans = Math.max(ans, getMinDist(str));
                str[i] = '0';
            }
        }
        
        System.out.print(ans);
    }

    static void getMinDist(char[] str) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str[i] == '1' && str[j] == '1') {
                    min = Math.min(min, Math.abs(i - j));
                }
            }
        }

        return min;
    }
}