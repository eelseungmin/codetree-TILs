import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;
        int[] pos = new int[11];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            int curIdx = sc.nextInt();
            int curPos = sc.nextInt();
            if (pos[curIdx] == -1) {
                pos[curIdx] = curPos;
                continue;
            }
            if (pos[curIdx] != curPos) {
                ans++;
                pos[curIdx] = curPos;
            }
        }

        System.out.print(ans);
    }
}