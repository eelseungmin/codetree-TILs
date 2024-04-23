import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static String str;
    static int[] alpha = new int[26];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        choose(0);

        System.out.print(max);
    }

    static int calc() {
        if (str.length() == 1) {
            return alpha[str.charAt(0) - 'a'];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a') {
                sb.append(alpha[0]);
            } else if (ch == 'b') {
                sb.append(alpha[1]);
            } else if (ch == 'c') {
                sb.append(alpha[2]);
            } else if (ch == 'd') {
                sb.append(alpha[3]);
            } else if (ch == 'e') {
                sb.append(alpha[4]);
            } else if (ch == 'f') {
                sb.append(alpha[5]);
            } else {
                sb.append(ch);
            }
        }

        char[] calcStr = sb.toString().toCharArray();
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {            
            if (calcStr[i] == '+') {
                if (i == 1) {
                    result = (calcStr[i - 1] - '0') + (calcStr[i + 1] - '0');
                } else {
                    result = result + (calcStr[i + 1] - '0');
                }
            } else if (calcStr[i] == '-') {
                if (i == 1) {
                    result = (calcStr[i - 1] - '0') - (calcStr[i + 1] - '0');
                } else {
                    result = result - (calcStr[i + 1] - '0');
                }
            } else if (calcStr[i] == '*') {
                if (i == 1) {
                    result = (calcStr[i - 1] - '0') * (calcStr[i + 1] - '0');
                } else {
                    result = result * (calcStr[i + 1] - '0');
                }
            } else {
            }
        }

        return result;
    }

    static void choose(int idx) {
        if (idx == 6) {
            max = Math.max(max, calc());
            return;
        }

        for (int i = 1; i <= 4; i++) {
            alpha[idx] = i;
            choose(idx + 1);
        }
    }
}