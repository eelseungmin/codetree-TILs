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
        for (int i = 0; i < n; i++) {
            if (seat[i] == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (seat[j] == '1') {
                        if (diff < j - i) {
                            diff = j - i;
                            l = i;
                            r = j;
                        } 
                        break;
                    }
                }
            }
        }

        boolean flag = false;
        if (seat[n - 1] == '0') {
            for (int i = n - 2; i >= 0; i--) {
                if (seat[i] == '1') {
                    if (diff < n - 1 - i) {
                        flag = true;
                    }
                    break;
                }
            }
        }

        if (flag) {
            seat[n - 1] = '1';
        } else {
            seat[(l + r) / 2] = '1';
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (seat[i] == '1') {
                for (int j = i + 1; j < n; j++) {
                    if (j - i != 1 && seat[j] == '1') {
                       ans = Math.min(ans, j - i); 
                       break;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}