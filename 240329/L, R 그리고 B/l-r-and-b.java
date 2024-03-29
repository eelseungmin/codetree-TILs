import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        char[][] map = new char[10][10];
        int LRow = 0;
        int LCol = 0;
        int RRow = 0;
        int RCol = 0;
        int BRow = 0;
        int BCol = 0;
        for (int i = 0; i < 10; i++) {
            String tmp = sc.next();
            for (int j = 0; j < 10; j++) {
                char ch = tmp.charAt(j);
                if (ch == 'L') {
                    LRow = i;
                    LCol = j;
                } else if (ch == 'R') {
                    RRow = i;
                    RCol = j;
                } else if (ch == 'B') {
                    BRow = i;
                    BCol = j;
                }
            }
        }

        // 전부 절댓값 사용
        int dist = 0;
   
        // 같은 선상에 위치
        if (LCol == BCol && BCol == RCol) {
            if ((LRow <= RRow && RRow <= BRow) || (BRow <= RRow && RRow <= LRow)) {
                dist += Math.abs(LRow - BRow) + 1;
            } else {
                dist += Math.abs(LRow - BRow) - 1;
            }
        } else if (LRow == BRow && BRow == RRow) {
            if ((LCol <= RCol && RCol <= BCol) || (BCol <= RCol && RCol <= LCol)) {
                dist += Math.abs(LCol - BCol) + 1;
            } else {
                dist += Math.abs(LCol - BCol) - 1;
            }
        } else {
            dist += Math.abs(LCol - BCol) + Math.abs(LRow - BRow) - 1;
        }

        System.out.print(dist);
    }
}