import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dev = new int[n][2];
        for (int i = 0; i < n; i++) {
            dev[i][0] = sc.nextInt();
            dev[i][1] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int time[] = new int[1001];
            int play = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = dev[j][0]; k < dev[j][1]; k++) {
                    time[k]++;
                }
            }
            for (int k = 1; k < 1001; k++) {
                if (time[k] != 0) play++;
            }
            max = Math.max(max, play);
        }
        System.out.print(max);
    }
}