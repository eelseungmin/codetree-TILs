import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] charArr = sc.next().toCharArray();
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (charArr[i] == '0') {
                charArr[i] = '1';
                for (int j = i + 1; j < n; j++) {
                    if (charArr[j] == '0') {
                        charArr[j] = '1';
                        ans = Math.max(ans, getMinDist(n, charArr));
                        charArr[j] = '0';
                    }
                }
                charArr[i] = '0';
            }
        }

        System.out.print(ans);
    }

    public static int getMinDist(int n, char[] arr) {
        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == '1' && arr[j] == '1') {
                    dist = Math.min(dist, j - i);
                }
            }
        }

        return dist;
    }
}