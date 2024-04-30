import java.util.*;

public class Main {
    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        choose(0);
    }

    static void choose(int idx) {
        if (idx == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(list.get(i));
            }
            System.exit(0);
        }

        for (int i = 4; i <= 6; i++) {
            list.add(i);
            if (isPossible()) {
                choose(idx + 1);
            }
            list.remove(list.size() - 1);
        }
    }

    static boolean isPossible() {
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 0; j + 2 * i <= list.size(); j++) {
                String tmp1 = "";
                String tmp2 = "";
                for (int k = j; k < j + i; k++) {
                    tmp1 += list.get(k);
                }
                for (int k = j + i; k < j + 2 * i; k++) {
                    tmp2 += list.get(k);
                }
                
                if (tmp1.equals(tmp2)) {
                    return false;
                }
            }
        }

        return true;  
    }
}