import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 뒤에서부터 보면서 정렬되지 않는 숫자들만 옮겨주면 됨
        // 1 2 4 3
        // 2 3
        int idx = n - 2;
        while (idx >= 0 && arr[idx] < arr[idx + 1]) {
            idx--;
        }

        System.out.print(idx + 1);
    }
}