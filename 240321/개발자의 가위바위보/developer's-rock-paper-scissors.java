import java.util.*;

public class Main {
    static int[] dev1, dev2;
    static int n;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dev1 = new int[n];
        dev2 = new int[n];

        for (int i = 0; i < n; i++) {
            dev1[i] = sc.nextInt();
            dev2[i] = sc.nextInt();
        }

        // 1 가위 2 바위 3 보
        // 1 가위 2 보 3 바위
        // 1 바위 2 가위 3 보
        // 1 바위 2 보 3 가위
        // 1 보 2 가위 3 바위
        // 1 보 2 바위 3 가위

        // r > c
        // r < p
        // c > p
        int ans = 0;

        char[] rcp1 = {' ', 'c', 'r', 'p'};
        ans = Math.max(ans, calcWin(rcp1));

        char[] rcp2 = {' ', 'c', 'p', 'r'};
        ans = Math.max(ans, calcWin(rcp2));

        char[] rcp3 = {' ', 'r', 'c', 'p'};
        ans = Math.max(ans, calcWin(rcp3));

        char[] rcp4 = {' ', 'r', 'p', 'c'};
        ans = Math.max(ans, calcWin(rcp4));

        char[] rcp5 = {' ', 'p', 'c', 'r'};
        ans = Math.max(ans, calcWin(rcp5));

        char[] rcp6 = {' ', 'p', 'r', 'c'};
        ans = Math.max(ans, calcWin(rcp6));

        System.out.print(ans);
    }

    static int calcWin(char[] rcp) {
        int win = 0;
        for (int i = 0; i < n; i++) {
            char a = rcp[dev1[i]];
            char b = rcp[dev2[i]];
            if (a == 'r' && b == 'c') {
                win++;
            } else if (a == 'p' && b == 'r') {
                win++;
            } else if (a == 'c' && b == 'p') {
                win++;
            }
        }
        
        return win;
    }
}