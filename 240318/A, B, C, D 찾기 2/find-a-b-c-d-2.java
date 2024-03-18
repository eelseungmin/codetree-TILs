import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }

        for (int a = 1; a <= 40; a++) {
            for (int b = a; b <= 40; b++) {
                for (int c = b; c <= 40; c++) {
                    for (int d = c; d <= 40; d++) {
                        int[] arr2 = new int[]{a, b, c, d, a + b, b + c, c + d, d + a,
                        a + c, b + d, a + b + c, a + b + d, a + c + d, b + c + d,
                        a + b + c + d};

                        Arrays.sort(arr2);
                        Arrays.sort(arr);

                        boolean issame = true;

                        for(int i = 0; i < 15; i++)
                            if(arr[i] != arr2[i])
                                issame = false;
                    
                        if(issame)
                            System.out.print(a + " " + b + " " + c + " " + d);
                    }
                }
            }
        }
    }
}