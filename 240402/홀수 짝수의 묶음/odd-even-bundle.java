import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 최대 묶음 수 -> 한 묶음 당 수가 적어야 한다.
        // 짝수 - 짝수, 짝수 + 짝수, 홀수 + 홀수
        // 홀수 - 홀수, 홀수 + 짝수
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp % 2 == 0) {
                even.offer(tmp);
            } else {
                odd.offer(tmp);
            }
        }

        // 하나의 숫자만으로 묶음을 만들다가 더 이상 그럴 수 없을 경우 묶어서 만들면 최대
        int ans = 0;
        boolean isEven = true;
        while (true) {
            // 짝수
            if (isEven) {
                if (!even.isEmpty()) { // 짝수 1
                    even.poll();
                    ans++;
                } else if (odd.size() >= 2) { // 홀수 2
                    odd.poll();
                    odd.poll();
                    ans++;
                } else {
                    // 남아있는 숫자만으로 그룹 만들기 불가
                    // 합이 짝수인 그룹 + 홀수 -> 홀수
                    // 합이 홀수인 그룹 + 홀수 -> 짝수
                    if (odd.size() > 0) {
                        ans--;
                    }
                    break;
                }
                isEven = false;
            } else { // 홀수
                if (!odd.isEmpty()) {
                    odd.poll();
                    ans++;
                } else {
                    // 남아있는 숫자만으로 그룹 만들기 불가 
                    // 기존 합이 홀수인 그룹과 더하면 갯수 유지 가능
                    break;
                }
                isEven = true;
            }
        }

        System.out.print(ans);
    }
}