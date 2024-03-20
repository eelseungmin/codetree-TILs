import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        
        char[] info1 = new char[100];
        int[] info2 = new int[100];
        for (int i = 0; i < m; i++) {
            char c = sc.next().charAt(0);
            int u = sc.nextInt();
            info1[i] = c;
            info2[i] = u;
        }

        if (info2[p - 1] == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            
            char person = (char) (i + 'A');
            boolean read = false;
            for (int j = 0; j < m; j++) {
                if (info1[j] == person && info2[j] >= info2[p - 1])
                    read = true;
            }

            if (!read) {
                System.out.print((char) (i + 'A') + " ");
            }
        }
    }
}