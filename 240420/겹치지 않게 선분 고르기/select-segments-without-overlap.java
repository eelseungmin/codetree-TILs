import java.util.*;

class Pair {
    int x1, x2;

    Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {
    static int n;
    static Pair[] seg;
    static List<Pair> list;
    static int ans;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seg = new Pair[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seg[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        
        choose(0);

        System.out.print(ans);
    }

    static void choose(int idx) {
        if (idx == n) {
            if (possible()) {
                ans = Math.max(ans, n);
            }
            return;
        }

        // 각 선분을 고르고 안고르고
        list.add(seg[idx]);
        choose(idx + 1);
        list.remove(list.size() - 1);
        choose(idx + 1);
    }
    
    static boolean possible() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (isOverlap(list.get(i), list.get(j)))
                    return false;
            }
        }

        return true;
    }

    static boolean isOverlap(Pair a, Pair b) {
        return (a.x1 <= b.x1 && b.x1 <= a.x2) || (a.x1 <= b.x2 && b.x2 <= a.x2) ||
        (b.x1 <= a.x1 && a.x1 <= b.x2) || (b.x1 <= a.x2 && a.x2 <= b.x2);
    }
}