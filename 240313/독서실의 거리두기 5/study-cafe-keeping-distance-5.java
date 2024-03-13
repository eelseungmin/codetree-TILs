import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '0') {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (i != j && s.charAt(j) == '1') {
                        if (Math.abs(i - j) < min) {
                            min = Math.abs(i - j);
                        }
                    }
                }
                max = Math.max(max, min);
            }
        }

        System.out.print(max);
    }
}