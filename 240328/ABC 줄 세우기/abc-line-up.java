import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] pos = new char[n];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.next().charAt(0);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (pos[i] != (char)((int)'A' + i)) {
                while (pos[i] != (char)((int)'A' + i)) {
                    for (int j = 0; j < n; j++) {
                        if (pos[j] == (char)((int)'A' + i)) {
                            if (i < j) {
                                char temp = pos[j - 1];
                                pos[j - 1] = pos[j];
                                pos[j] = temp;
                                ans++;
                                break;
                            } else {
                                char temp = pos[j + 1];
                                pos[j + 1] = pos[j];
                                pos[j] = temp;
                                ans++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(ans);
    }
}