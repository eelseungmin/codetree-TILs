import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        choose(0);
    }

    static void choose(int idx) {
        if (idx == n) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }   

        for (int i = 1; i <= k; i++) {
            if (n >= 3 && arr[idx - 2] == arr[idx - 1] && arr[idx - 1] == i) continue;
            arr[idx] = i;
            choose(idx + 1);
        }
    }
}