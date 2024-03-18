import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for (int h = 0; h <= 100; h++) {
            
            int cnt = 0;
            int cntL = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] >= h) {
                    cnt++;
                } else if (arr[j] == h - 1) {
                    if (cntL < l) {
                        cnt++;
                        cntL++;
                    }
                }
            }
            if (cnt >= h) {
                max = Math.max(max, h);
            }
        }

        System.out.print(max);
    }
}