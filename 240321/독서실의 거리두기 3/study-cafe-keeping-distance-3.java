import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] seat = sc.next().toCharArray();

        int l = -1;
        int r = -1;
        int diff = 0;
        // 10001001
        // 10100001
        for (int i = 0; i < n; i++) {
            if (seat[i] == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (seat[j] == '1') {
                        if (diff < j - i) {
                            l = i;
                            r = j;
                            diff = j - i;
                        }
                        break;
                    }
                }
            }
        }
        
        // 10001
        // 1001
        // 100001 0  5
        seat[(l + r) / 2] = '1';

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (seat[i] == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (seat[j] == '1' && j - i > 0) {
                        ans = Math.min(ans, j - i);
                        break;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}