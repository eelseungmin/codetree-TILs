import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
            num[i] = temp;
        }

        Arrays.sort(num);
        // 10 2
        // 11111 2
        // 1 2 3 4 5

        int target = -1;
        boolean two = false;
        for (int i = 0; i < n; i++) {
            if (target == -1) {
                target = num[i];
            } else if (target < num[i]) {
                target = num[i];
                two = true;
                break;
            }
        }

        if (!two) {
            System.out.print(-1);
            return;
        }

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                cnt++;
                ans = i + 1;
            }
        }

        if (cnt == 1) {
            System.out.print(ans);
        } else {
            System.out.print(-1);
        }
    }
}