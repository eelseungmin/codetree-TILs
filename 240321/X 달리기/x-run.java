import java.util.*;

public class Main {
    static int x;
    static int time;
    static int dist;
    static int speed;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();

        time = 0;
        dist = 0;
        speed = 1;
        while (dist < x) {
            time++;
            dist += speed;

            // 가속할 수 있는지 판단
            // 그럴 수 없다면 유지할 수 있는지 판단
            // 그 외의 경우 감속
            // v, v-1, ... , 3, 2, 1로 줄어드므로 등차수열의 합을 구하는 공식 사용
            if (x - (dist + speed + 1) >= speed * (speed + 1) / 2) {
                speed++;
            } else if (x - (dist + speed) >= speed * (speed - 1) / 2) { 
                continue;
            } else {
                speed--;
            }
        }

        System.out.print(time);
    }
}