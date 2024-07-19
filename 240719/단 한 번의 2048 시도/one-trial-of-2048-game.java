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
            push();
            sum();
        } else if (dir == 'R') {
            rotate(map);
            rotate(map);
            push();
            sum();
            rotate(ans);
            rotate(ans);
        } else if (dir == 'U') {
            rotate(map);
            rotate(map);
            rotate(map);
            push();
            rotate(ans);
        } else {
            rotate(map);
            push();
            sum();
            rotate(ans);
            rotate(ans);
            rotate(ans);
        }
    }

    static void push() {
        for (int i = 0; i < 4; i++) {
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < 4; j++) {
                if (map[i][j] != 0) q.offer(map[i][j]);
            }
            int idx = 0;
            for (int j = 0; j < 4; j++) {
                if (!q.isEmpty()) map[i][j] = q.poll();
                else map[i][j] = 0;
            }
        }

        // System.out.println("push");
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }

    static void sum() {
        for (int i = 0; i < 4; i++) {
            int idx = 0;
            for (int j = 0; j <= 3; j++) {
                if (j == 3) {
                    ans[i][idx] = map[i][j];
                    break;
                }
                if (map[i][j] != map[i][j + 1]) {
                    if (ans[i][j] != 0 && map[i][j] == 0) {
                        ans[i][idx] = map[i][j];
                        break;
                    } else {
                        ans[i][idx++] = map[i][j];
                        if (j == 2) { 
                            ans[i][idx] = map[i][j + 1];
                            break;
                        }
                    }
                } else {
                    ans[i][idx++] = map[i][j] * 2;
                    j++;
                }
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

        // System.out.println("rotate");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                target[i][j] = tmp[i][j];
                // System.out.print(target[i][j] + " ");
            }
            // System.out.println();
        }
        // System.out.println();
    }
}