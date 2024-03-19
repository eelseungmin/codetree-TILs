import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();

        boolean inter = false;
        for (int i = x1; i <= x2; i++) {
            if (i == x3) inter = true;
            if (i == x4) inter = true;
        }
        for (int i = x3; i <= x4; i++) {
            if (i == x1) inter = true;
            if (i == x2) inter = true;
        }

        if (inter) System.out.print("intersecting");
        else System.out.print("nonintersecting");
    }
}