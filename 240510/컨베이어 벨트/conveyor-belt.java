import java.util.*;

public class Main {
    static int n, t;
    static int[] arr1;
    static int[] arr2;
    static int temp1, temp2;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        arr1 = new int[n];
        arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        // 각각의 변의 마지막 값이 상대편의 첫번째 값으로 이동
        while (t-- > 0) {
            temp1 = arr1[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                arr1[i + 1] = arr1[i];
            }
            temp2 = arr2[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                arr2[i + 1] = arr2[i];
            }
            arr2[0] = temp1;
            arr1[0] = temp2;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}