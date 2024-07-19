import java.util.*;

public class Main {
    static int[][] map;
    static int[][] ans;
    static char dir = '\u0000';

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        map = new int[4][4];
        ans = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dir = sc.next().charAt(0);

        simulation();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void simulation() {
        // 방향 확인
        // L일 경우만 구현한 뒤 다른 방향은 rotate 메서드를 작성해서 배열 자체를 L과 동일한 방향으로 변경해서 해결
        // L일 때 먼저 배열 숫자를 전부 왼쪽으로 민다.
        // 이후 합치기 작업 수행
        // 수행한 결과를 ans 배열에 입력
        if (dir == 'L') {
            sum();
        } else if (dir == 'R') {
            rotate(map);
            rotate(map);
            sum();
            rotate(ans);
            rotate(ans);
        } else if (dir == 'U') {
            rotate(map);
            rotate(map);
            rotate(map);
            sum();
            rotate(ans);
        } else {
            rotate(map);
            sum();
            rotate(ans);
            rotate(ans);
            rotate(ans);
        }
    }

    static void sum() {
        for (int i = 0; i < 4; i++) {
            int idx = 0;
            int keepNum = -1;
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 0) continue;
                // 가장 최근에 관찰한 숫자가 없다면 갱신
                if (keepNum == -1) {
                    keepNum = map[i][j];
                    // 가장 최근에 관찰한 숫자가 현재 숫자와 일치한다면
                    // 합친 뒤 관찰한 숫자 초기화(한 번만 합치고 다음 쌍으로 넘어가야 하므로)
                } else if (keepNum == map[i][j]) {
                    ans[i][idx++] = keepNum * 2;
                    keepNum = -1;
                    // 가장 최근에 관찰한 숫자가 현재 숫자와 다르다면
                    // 관찰한 숫자를 배열에 기록한 뒤, 관찰한 숫자 갱신
                } else {
                    ans[i][idx++] = keepNum;
                    keepNum = map[i][j];
                }
            }

            // 가장 최근에 관찰한 숫자가 남아있는 경우, 끄트머리에 혼자 남은 것이므로 배열에 기록
            if (keepNum != -1) {
                ans[i][idx++] = keepNum;
            }
        }
    }

    static void rotate(int[][] target) {
        int[][] tmp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[j][3 - i] = target[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                target[i][j] = tmp[i][j];
            }
        }
    }
}