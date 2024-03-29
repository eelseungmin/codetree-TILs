import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            if (tmp > 0) {
                plus.add(tmp);
            } else if (tmp == 0) {
                zero.add(tmp);
            } else  {
                minus.add(tmp);
            }
        }

        // 양수 3개 -> 가장 큰 수 3개
        // 음수 1개, 양수 2개 -> 음수는 절대값이 가장 작은 것, 양수는 가장 작은 수 2개
        // 음수 2개, 양수 1개 -> 음수는 절대값이 가장 큰 것 2개, 양수는 가장 큰 수 1개
        // 음수 3개 -> 절대값이 가장 작은 것 3개
        // 0이 하나라도 포함되어 있다면 무조건 0

        Collections.sort(plus);
        Collections.sort(zero);
        Collections.sort(minus);
        
        int ans = Integer.MIN_VALUE;

        int psize = plus.size();
        int zsize = zero.size();
        int msize = minus.size();
        if (psize >= 3) {
            ans = Math.max(ans, plus.get(psize - 1) * plus.get(psize - 2) * plus.get(psize - 3));
        }

        if (msize >= 3) {
            ans = Math.max(ans, minus.get(msize - 1) * minus.get(msize - 2) * minus.get(msize - 3));
        }

        if (msize >= 1 && psize >= 2) {
            ans = Math.max(ans, minus.get(msize - 1) * plus.get(0) * plus.get(1));
        }

        if (msize >= 2 && psize >= 1) {
            ans = Math.max(ans, plus.get(psize - 1) * minus.get(0) * minus.get(1));
        }

        if (zsize >= 1) {
            ans = Math.max(ans, 0);
        }

        System.out.print(ans);
    }
}