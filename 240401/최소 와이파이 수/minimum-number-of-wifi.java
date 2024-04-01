import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] live = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp == 1) {
                live[i + 1] = true;
            } else {
                live[i + 1] = false;
            }
        }

        // 가장 왼쪽 집에 사는 사람을 커버하는 가장 우측 위치
        // 즉 와이파이를 놓은 뒤 다음 위치로 이동하면 2m만큼 이동하게 된다.
        // 1 2 3 4 5
        // 1 1 0 1 1
        int ans = 0;
        boolean[] covered = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (live[i]) {
                ans++;
                i += 2 * m;
            }
        }

        System.out.print(ans);
    }
}