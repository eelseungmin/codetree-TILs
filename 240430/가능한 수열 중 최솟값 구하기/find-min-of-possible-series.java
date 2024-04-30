import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        choose(0);

        System.out.print(list.get(0));
    }

    static void choose(int idx) {
        if (idx == n) {
            if (isPossible()) {
                String ans = "";
                for (int i = 0; i < n; i++) {
                    ans += arr[i] + "";
                }
                list.add(ans);
            }
            return;
        }

        for (int i = 4; i <= 6; i++) {
            arr[idx] = i;
            choose(idx + 1);
        }
    }

    static boolean isPossible() {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j + 2 * i <= n; j++) {
                String tmp1 = "";
                String tmp2 = "";
                for (int k = j; k < j + i; k++) {
                    tmp1 += arr[k];
                }
                for (int k = j + i; k < j + 2 * i; k++) {
                    tmp2 += arr[k];
                }
                
                if (tmp1.equals(tmp2)) {
                    return false;
                }
            }
        }

        return true;  
    }
}