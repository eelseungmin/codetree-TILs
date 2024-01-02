import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        int price;
        int trans;

        Student(int price, int trans) {
            this.price = price;
            this.trans = trans;
        }

        @Override
        public int compareTo(Student s) {
            if (this.price == s.price) {
                return this.trans - s.trans;
            }
            return this.price - s.price;
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        Student[] s = new Student[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Student(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(s);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int budget = b;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j && budget - s[j].price / 2 - s[j].trans >= 0) {
                    budget -= s[j].price / 2;
                    budget -= s[j].trans;
                    cnt++;
                } else if (budget - s[j].price - s[j].trans >= 0) {
                    budget = budget - s[j].price - s[j].trans;
                    cnt++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.print(ans);
    }
}