import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.next().charAt(0);
            }
        }

        int cnt = 0;
        // 0,0 출발과 r-1,c-1 도착은 고정
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                for (int k = i + 1; k < r - 1; k++) {
                    for (int h = j + 1; h < c - 1; h++) {
                        if (map[0][0] != map[i][j] && map[i][j] != map[k][h] && map[k][h] != map[r - 1][c - 1]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        
        System.out.print(cnt);
    }
}