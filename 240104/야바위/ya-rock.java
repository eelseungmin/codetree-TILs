import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] simul = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                simul[i][j] = sc.nextInt();
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= 3; i++) {
            int score = 0;
            int stone = i;
            for (int j = 0; j < n; j++) {
                if (stone == simul[j][0]) {
                    stone = simul[j][1];
                } else if (stone == simul[j][1]) {
                    stone = simul[j][0];
                }

                if (simul[j][2] == stone) score++;
            }
            
            ans = Math.max(ans, score);
        }

        System.out.print(ans);
    }
}