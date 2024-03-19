import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int[] x = new int[2];
        int[] y = new int[2];
        int[] a = new int[2];
        int[] b = new int[2];
        for (int i = 0; i < 2; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        
        boolean overlap = true;
        if (x[0] > a[1] || x[1] < a[0] || y[0] > b[1] || b[0] > y[1]) overlap = false;

        if (overlap) System.out.print("overlapping");
        else System.out.print("nonoverapping");
    }
}