import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        
        boolean[] readers = new boolean[26];
        char[] info1 = new char[100];
        int[] info2 = new int[100];
        for (int i = 0; i < m; i++) {
            char c = sc.next().charAt(0);
            int u = sc.nextInt();
            info1[i] = c;
            info2[i] = u;
        }

        for (int i = p - 1; i < m; i++) {
            if (i == p - 1 && info2[i] == info2[i - 1]) {
                readers[info1[i - 1] - 'A'] = true;
                continue;
            }
            readers[info1[i] - 'A'] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!readers[i]) {
                System.out.print((char) (i + 'A') + " ");
            }
        }
    }
}