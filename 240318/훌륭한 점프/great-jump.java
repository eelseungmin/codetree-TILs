import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int k;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int max = Math.max(arr[0], arr[4]); max <= 100; max++) {
            if(isPossible(max)) {
                System.out.print(max);
                break;
            }
        }

    }

    public static boolean isPossible(int val) {
        int cnt = 0;
        int[] tries = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] <= val) {
                tries[cnt++] = i;
            }
        }

        for (int i = 1; i < cnt; i++) {
            if (tries[i] - tries[i - 1] > k) 
                return false;
        }

        return true;
    }
}